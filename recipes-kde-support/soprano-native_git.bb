LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"
DEPENDS = "redland-native virtuoso-native raptor-native libiodbc-native"
SRCREV = "649dc0a271f0a291cbaa0da04554c4a5f5ebdfab"
PV = "2.8.5+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
           file://Fix-Redland-cross-compile-error.patch \
           file://WORKAROUND-export-visibility.patch \
          "

S = "${WORKDIR}/git"

inherit kde_cmake native

EXTRA_OECMAKE =+ "\
                  -DBUILD_VIRTUOSO_BACKEND=TRUE \
                  -DBUILD_RAPTOR_PARSER=TRUE \
                  -DBUILD_REDLAND_BACKEND=TRUE \
                  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
                 "
