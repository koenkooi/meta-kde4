LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

inherit kde_cmake native

DEPENDS = "redland-native virtuoso-native raptor-native libiodbc-native"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
	   file://Fix-Redland-cross-compile-error.patch \
	   file://WORKAROUND-export-visibility.patch \
	  "

SRCREV = "2321148537033c69c0f358b928486a1b1b003753"

EXTRA_OECMAKE =+ "\
		  -DBUILD_VIRTUOSO_BACKEND=TRUE \
		  -DBUILD_RAPTOR_PARSER=TRUE \
		  -DBUILD_REDLAND_BACKEND=TRUE \
		  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
		 "

PV = "2.8.0+git${SRCPV}"
PR = "r1"

S = "${WORKDIR}/git"