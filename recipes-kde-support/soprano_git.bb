LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

inherit kde_cmake

DEPENDS = "redland virtuoso raptor libiodbc"

RDEPENDS_${PN} = "virtuoso raptor rasqal redland"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
	   file://Fix-Redland-cross-compile-error.patch \
	   file://WORKAROUND-export-visibility.patch \
	  "

SRCREV = "649dc0a271f0a291cbaa0da04554c4a5f5ebdfab"

#Note: the cmake patch for redland could be resolved with a TryRun.cmake file, however since the cmake file will be installed for other programs it would be needed at every program using it.

FILES_${PN} =+ "${libdir}/soprano/* \
		${datadir}/dbus-1/* \
	       "

FILES_${PN}-dev += "${datadir}/soprano/cmake/*"

EXTRA_OECMAKE =+ "\
		  -DBUILD_VIRTUOSO_BACKEND=TRUE \
		  -DBUILD_RAPTOR_PARSER=TRUE \
		  -DBUILD_REDLAND_BACKEND=TRUE \
		  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
		 "

PV = "2.8.5+git${SRCPV}"
PR = "r1"

S = "${WORKDIR}/git"
