DESCRIPTION = "KDE task for Plasma Active"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit task

RDEPENDS_${PN} += "\
    plasma-active \
    startactive \
    contour \
    plasma-contour-config \
    share-like-connect \
"