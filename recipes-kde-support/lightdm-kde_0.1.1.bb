LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "kdelibs4 lightdm"

SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/lightdm-kde_${PV}.orig.tar.bz2"

inherit kde_cmake

RDEPENDS_${PN} = "lightdm"

FILES_${PN} += "/usr/lib/kde4/kcm_lightdm.so \
    ${datadir}"
FILES_${PN}-dbg += "/usr/lib/kde4/.debug"
