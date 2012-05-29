LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

inherit kde_cmake native

DEPENDS = "redland virtuoso raptor libiodbc"

RDEPENDS_${PN} = "virtuoso raptor rasqal redland"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
	   file://Fix-Redland-cross-compile-error.patch \
	   file://WORKAROUND-export-visibility.patch \
	  "

SRCREV = "2f5381c4c449f5c0b1390f7eaf00ef9216f8b5fa"

EXTRA_OECMAKE =+ "\
		  -DBUILD_VIRTUOSO_BACKEND=TRUE \
		  -DBUILD_RAPTOR_PARSER=TRUE \
		  -DBUILD_REDLAND_BACKEND=TRUE \
		  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
		 "

PV = "2.7.53+git${SRCPV}"
PR = "r1"

S = "${WORKDIR}/git"