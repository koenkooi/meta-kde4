#Note: the cmake patch for redland could be resolved with a TryRun.cmake file, however since the cmake file will be installed for other programs it would be needed at every program using it.
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"
DEPENDS = "redland virtuoso raptor libiodbc"
SRCREV = "4085f0cb1a38ef3e5b9a223b395db82186b2de93"
PV = "2.9.0+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master \
           file://Fix-Redland-cross-compile-error.patch \
           file://WORKAROUND-export-visibility.patch \
          "

S = "${WORKDIR}/git"

inherit kde_cmake

EXTRA_OECMAKE =+ "\
                  -DBUILD_VIRTUOSO_BACKEND=TRUE \
                  -DBUILD_RAPTOR_PARSER=TRUE \
                  -DBUILD_REDLAND_BACKEND=TRUE \
                  -DREDLAND_CONFIG_EXECUTABLE=${STAGING_DIR_TARGET}${bindir_crossscripts}/redland-config \
                 "

RDEPENDS_${PN} = "virtuoso raptor rasqal redland"

FILES_${PN} =+ "${libdir}/soprano/* \
                ${datadir}/dbus-1/* \
               "
FILES_${PN}-dev += "${datadir}/soprano/cmake/*"
