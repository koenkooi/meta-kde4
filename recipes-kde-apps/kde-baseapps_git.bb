LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kdelibs4 soprano"
## Tag v4.8.0
SRCREV = "a7a128232033f284d41890a6967fc0641925b251"
PV = "4.8.0+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/kde-baseapps;protocol=git;branch=master \
           file://Convert-Phonon-to-phonon.patch"

S = "${WORKDIR}/git"

inherit kde_without_docs kde_rdepends kde_cmake

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    ${libdir}/libkdeinit4*.so \
    \
    ${datadir}/* \
    "
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
FILES_${PN}-dev += "${libdir}/libdolphinprivate.so \
    ${libdir}/libkbookmarkmodel_private.so \
    ${libdir}/libkonq.so \
    ${libdir}/libkonqsidebarplugin.so \
    "

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
