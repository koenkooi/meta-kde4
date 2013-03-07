DESCRIPTION = "KDE packagegroup for applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RDEPENDS_${PN} += "\
ark \
bangarang \
declarative-plasmoids \
gwenview \
kate \
kcalc \
kde-baseapps \
konsole \
ksnapshot \
okular \
rekonq \
\
"
