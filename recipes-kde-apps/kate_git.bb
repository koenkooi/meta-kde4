LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://kate/COPYING.LIB;md5=156642aa865c263a96e2cdd7a5cc8570"
DEPENDS = "kdelibs4"
## Tag 4.8.0
SRCREV = "78edc645422be447e7d451ed86e2fe690ae303e1"
PV = "4.8.0+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/kate;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit kde_cmake kde_without_docs kde_rdepends perlnative

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    ${libdir}/libkdeinit4*.so \
    \
    ${datadir}/* \
    "
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
FILES_${PN}-dev += "${libdir}/libkateinterfaces.so \
    ${libdir}/libkatepartinterfaces.so \
    ${libdir}/libktexteditor_codesnippets_core.so \
    "

# kate *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
