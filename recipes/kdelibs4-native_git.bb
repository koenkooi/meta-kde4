LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4-helper-native automoc4-native giflib attica jpeg libpng bzip2"

#soprano
#strigi-native
#libphonon-native
DEPENDS_virtclass-native = "perl-native "

inherit mime native perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Disable-documentation.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Fix-Qt-Phonon-and-kconfig_compiler.patch \
	  "

SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


do_compile() {
  cd ${S}/build
  make -C kdecore/kconfig_compiler
  make -C kjs icemaker
}

do_install() {
  install -d ${D}${bindir}
  install -d ${D}${datadir}/apps/cmake/modules
  install -m 0755 ${S}/build/bin/icemaker ${D}${bindir}
  install -m 0755 ${S}/build/bin/kconfig_compiler ${D}${bindir}

  install -m 0755 ${S}/build/KDELibsDependencies.cmake ${D}${datadir}/apps/cmake/modules
  install -m 0755 ${S}/build/KDEPlatformProfile.cmake ${D}${datadir}/apps/cmake/modules
  cd ${S}/build/cmake && oe_runmake install DESTDIR=${D}
  cd ${S}/build/includes && oe_runmake install DESTDIR=${D}
}

EXTRA_OECMAKE =+ "\
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		 "
