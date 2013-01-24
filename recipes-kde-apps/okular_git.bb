LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2"
DEPENDS = "freetype kdelibs4 libkactivities4 shared-desktop-ontologies qimageblitz"
## Tag 4.10.0
SRCREV = "00cbba3ecec708cb147e990112bb3074778eca65"
PV = "4.10.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/okular.git;protocol=git;branch=master \
    file://Fix-Phonon-to-phonon.patch \
    file://Fix-Namespace-to-NameSpace-in-kconfig-files.patch \
    "

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends kde_without_docs perlnative

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/imports/org/kde/okular/libokularplugin.so \
    \
    ${datadir}/ \
    ${datadir}/apps/okular/* \
    ${datadir}/config.kcfg \
    ${datadir}/kde4/* \
    ${datadir}/icons/* \
    "

FILES_${PN}-dev += "\
    ${libdir}/cmake/* \
    ${libdir}/kde4/imports/org/kde/okular/qmldir \
    "

FILES_${PN}-dbg += "\
    ${libdir}/kde4/.debug/* \
    ${libdir}/kde4/imports/org/kde/okular/.debug \
    "

# Build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
