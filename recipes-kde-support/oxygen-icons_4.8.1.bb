LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e01bfa20e899e8ad569d5488923cbd2"

inherit cmake

SRC_URI = "ftp://ftp.kde.org/pub/kde/stable/${PV}/src/oxygen-icons-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/icons/oxygen/*"

SRC_URI[md5sum] = "26c37757f5d969f7e4c82dfe94a15d18"
SRC_URI[sha256sum] = "ea070618df8a69cc92e6501def401ed4d5fa1188542e3155a20e01d149b64662"

# This package contains only data (E.g. 6797 images under /usr/share/icons), skipping insane checks will reduce the packaging time by 98%
INSANE_SKIP_${PN} = "True"
