DESCRIPTION = "KDE packages for basic features"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RDEPENDS_${PN} += "\
    kdelibs4 \
    kde-runtime \
    kde-workspace \
    libkactivities4 \
"
