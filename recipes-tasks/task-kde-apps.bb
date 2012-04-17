DESCRIPTION = "KDE task for applications"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit task

RDEPENDS_${PN} += "\
kate \
konsole \
kcalc \
bangarang \
okular \
kde-baseapps \
declarative-plasmoids \
\
calligra \
calligra-braindump \
calligra-flow \
calligra-karbon \
calligra-kexi \
calligra-krita \
calligra-stage \
calligra-words \
"