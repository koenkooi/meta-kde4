LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

#inherit qt4x11 cmake
require kde4.inc

DEPENDS = "virtuoso raptor"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
	   file://Fix-Redland-cross-compile-error.patch \
	   file://WORKAROUND-export-visibility.patch \
	  "

SRCREV = "2f5381c4c449f5c0b1390f7eaf00ef9216f8b5fa"

#Note: the cmake patch for redland could be resolved with a TryRun.cmake file, however since the cmake file will be installed for other programs it would be needed at every program using it.

FILES_${PN} =+ "${libdir}libsopranoserver.*"


do_compile() {
  cd ${S}/soprano && oe_runmake CC="${CC}" CXX="${CXX}"
  cd ${S}/parsers/raptor && oe_runmake CC="${CC}" CXX="${CXX}"
  cd ${S}/client && oe_runmake CC="${CC}" CXX="${CXX}"
  cd ${S}/backends && oe_runmake CC="${CC}" CXX="${CXX}"

  # The target sopranod will not compile
  cd ${S}/server && oe_runmake sopranoserver CC="${CC}" CXX="${CXX}"
}

do_install() {
  cd ${S}/soprano && oe_runmake install DESTDIR=${D}
  cd ${S}/parsers/raptor && oe_runmake install DESTDIR=${D}
  cd ${S}/client && oe_runmake install DESTDIR=${D}
  cd ${S}/includes && oe_runmake install DESTDIR=${D}
  cd ${S}/backends && oe_runmake install DESTDIR=${D}
  cd ${S}/cmake && oe_runmake install DESTDIR=${D}

  # This needs to be installed manually as sopranod is seriously broken and also not needed
  install -d ${D}${libdir}
  install -m 0644 ${S}/server/libsopranoserver.* ${D}${libdir}/
}

EXTRA_OECMAKE =+ "\
		  -DBUILD_VIRTUOSO_BACKEND=TRUE \
		  -DBUILD_RAPTOR_PARSER=TRUE \
		  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
		 "

PV = "2.7.53+git${SRCPV}"

S = "${WORKDIR}/git"