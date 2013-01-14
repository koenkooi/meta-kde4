LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kdelibs4 kde-baseapps"
## Tag 4.8.0
SRCREV = "dc6ac6855cf6c57589fd322eecf0d3e590b3779a"
PV = "4.8.0+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/konsole.git;protocol=git;branch=master \
           file://Make-docs-optional.patch"

S = "${WORKDIR}/git"

inherit kde_without_docs kde_rdepends kde_cmake

RDEPENDS_${PN} = "kde-baseapps"

FILES_${PN} += "\
                ${libdir}/kde4/*.so \
                ${libdir}/libkdeinit4_konsole.so \
                ${libdir}/libkonsoleprivate.so \
                \
                ${datadir}/* \
               "
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
