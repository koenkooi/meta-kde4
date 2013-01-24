LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/lib/core/info.h;md5=f396333893be4f7a0a8c37fa51e2eb7f;beginline=1;endline=16"
DEPENDS = "nepomuk-core kdelibs4 shared-desktop-ontologies soprano"
## Tag v4.10.0
SRCREV = "266e26d1d76fd9866efed414967c283cd36d4477"
PV = "4.10.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master \
    file://Don-t-runtest-cross-compiled-code.patch"

S = "${WORKDIR}/git"

inherit kde_exports kde_rdepends kde_cmake

EXTRA_OECMAKE += "-DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl"

RDEPENDS_${PN} = "soprano shared-desktop-ontologies qt4-plugin-sqldriver-sqlite"

FILES_${PN} += "\
    ${bindir}/kactivitymanagerd \
    ${libdir}/libkactivities.so.* \
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/imports/org/kde/activities/models/libkactivities-models-component-plugin.so \
    ${datadir}/* \
    ${datadir}/services/*.desktop \
    ${datadir}/services/*.protocol \
    ${datadir}/servicetypes/*.desktop \
    ${datadir}/ontology/kde/kao.ontology \
    ${datadir}/ontology/kde/kao.trig \
    "

FILES_${PN}-dev += "\
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/libkactivities.so \
    ${libdir}/cmake/* \
    ${libdir}/kde4/imports/org/kde/activities/models/qmldir \
    "


FILES_${PN}-dbg += "\
    ${libdir}/kde4/imports/org/kde/activities/models/.debug \
    ${libdir}/kde4/.debug/* \
    "

KDE_EXPORT_FILES = "\
    ${S}/build/src/lib/core/CMakeFiles/Export/_usr/lib/cmake/KActivities/KActivitiesLibraryTargets-relwithdebinfo.cmake \
    ${S}/build/src/lib/models/CMakeFiles/Export/_usr/lib/cmake/KActivities-Models/KActivitiesModelsLibraryTargets-relwithdebinfo.cmake \
    ${S}/build/lib/KActivitiesConfig.cmake \
    ${S}/build/src/ontologies/kao.ontology \
    "

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
