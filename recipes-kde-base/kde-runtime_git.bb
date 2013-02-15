LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kdelibs4 libkactivities4 kdepimlibs soprano exiv2 soprano-native shared-desktop-ontologies nepomuk-core"
## Tag v4.10.0
SRCREV = "a9ca1460d154de5587a4b0a46fa2adb5ff857d24"
PV = "4.10.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit kde_without_docs kde_rdepends kde_cmake

EXTRA_OECMAKE =+ "\
    -DKDEBASE_DISABLE_MULTIMEDIA=ON \
    \
    -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules \
    "

PACKAGES =+ "${PN}-declarative-scriptengine"

RDEPENDS_${PN} = "soprano kdelibs4 ${PN}-declarative-scriptengine exiv2"

FILES_${PN} += "\
    ${libdir}/attica_kde.so \
    ${libdir}/libkdeinit4_*.so \
    ${libdir}/libknotifyplugin.so \
    ${libdir}/libnepomukcommon.so \
    ${libdir}/kde4/* \
    \
    ${datadir}/* \
    \
    ${sysconfdir}/* \
    "
FILES_${PN}-declarative-scriptengine += "\
    ${libdir}/kde4/imports/org/kde/plasma/core/libcorebindingsplugin.so \
    ${libdir}/kde4/imports/org/kde/plasma/core/qmldir \
    ${libdir}/kde4/imports/org/kde/plasma/graphicslayouts/libgraphicslayoutsbindingsplugin.so \
    ${libdir}/kde4/imports/org/kde/plasma/graphicslayouts/qmldir \
    ${libdir}/kde4/imports/org/kde/plasma/graphicswidgets/libgraphicswidgetsbindingsplugin.so \
    ${libdir}/kde4/imports/org/kde/plasma/graphicswidgets/qmldir \
    ${libdir}/kde4/plasma_appletscript_declarative.so \
    ${datadir}/kde4/services/plasma-scriptengine-applet-declarative.desktop \
    "
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
FILES_${PN}-dev += "\
    ${libdir}/libkwalletbackend.so \
    ${libdir}/libmolletnetwork.so \
    ${datadir}/apps/cmake/* \
    "
FILES_${PN}-dbg += "\
    ${libdir}/kde4/.debug/* \
    ${libdir}/kde4/libexec/.debug/* \
    ${libdir}/kde4/imports/org/kde/*/.debug/* \
    ${libdir}/kde4/imports/org/kde/plasma/*/.debug/* \
    ${libdir}/kde4/platformimports/touch/org/kde/plasma/components/.debug/* \
    "

# kde-runtime needs to be built out of source, see: http://www.mail-archive.com/release-team@kde.org/msg05797.html
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
