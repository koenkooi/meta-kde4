LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2"
DEPENDS = "kdelibs4 qimageblitz"
## Tag 4.8.4
SRCREV = "4a1b4ed736e0c5095246030e1e81d8282154880f"
PV = "4.8.4+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/okular.git;protocol=git;branch=master \
    file://Fix-Phonon-to-phonon.patch \
    file://Fix-typo-Namespace-to-NameSpace.patch"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends kde_without_docs perlnative

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    \
    ${datadir}/ \
    ${datadir}/apps/okular/* \
    ${datadir}/config.kcfg \
    ${datadir}/kde4/* \
    ${datadir}/icons/*"
FILES_${PN}-dev += "${libdir}/cmake/*"
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"

# Build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
