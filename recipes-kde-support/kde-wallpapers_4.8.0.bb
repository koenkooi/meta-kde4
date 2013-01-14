LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a6a8e020838b23406c81b19c1d46df6"
DEPENDS = "kdelibs4"

SRC_URI = "ftp://ftp.kde.org/pub/kde/stable/4.8.0/src/kde-wallpapers-4.8.0.tar.bz2"
SRC_URI[md5sum] = "396aa669ab31ab32f73f2278e6ca143a"
SRC_URI[sha256sum] = "f5f4139083ccfc703db90c22ede426d7532a730a0d625f79d681d13dc672c349"

inherit kde_cmake

PACKAGES = "${PN}"

FILES_${PN} += "${datadir}/*"
