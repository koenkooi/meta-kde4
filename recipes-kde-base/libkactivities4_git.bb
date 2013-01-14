LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/lib/info.h;md5=4547c0d20883d91da92544ee5fc15a0d;beginline=1;endline=16"
DEPENDS = "kdelibs4 soprano shared-desktop-ontologies"
## Tag v4.9.0
SRCREV = "ebcda7241b8de3c6d5284ec946521e5695e2082d"
PV = "4.9.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master \
           file://Fix-cmake-destination-directory.patch"

S = "${WORKDIR}/git"

inherit kde_exports kde_rdepends kde_cmake

EXTRA_OECMAKE += "-DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl"

RDEPENDS_${PN} = "soprano shared-desktop-ontologies qt4-plugin-sqldriver-sqlite"

FILES_${PN} += "\
                ${datadir}/kde4 \
        ${datadir}/ontology \
        ${datadir}/apps \
                \
                ${libdir}/kde4/*.so \
                \
                ${sysconfdir}/* \
               "
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
FILES_${PN}-dev += "${datadir}/apps/cmake/* \
                   "

KDE_EXPORT_FILES = "\
${S}/build/lib/CMakeFiles/Export/_usr/share/apps/cmake/modules/KActivitiesLibraryTargets-relwithdebinfo.cmake \
${S}/build/lib/KActivitiesConfig.cmake \
${S}/build/ontologies/kao.ontology"
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
