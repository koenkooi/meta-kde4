LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kde-workspace kde-runtime soprano shared-desktop-ontologies kdelibs4 libkactivities4"
#2012-04-11
SRCREV = "e0d27c737853298015dabe3fe9c1a4bc92c13cc0"
PV = "Active-Two+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/contour.git;branch=master"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends

RDEPENDS_${PN} = " kde-workspace libkactivities4 plasma-active shared-desktop-ontologies"

RRECOMMENDS_${PN} = "kde-wallpapers"

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    \
    ${datadir}/apps/contour/* \
    ${datadir}/apps/plasma/* \
    ${datadir}/kde4/* \
    ${datadir}/autostart/* \
    "
FILES_${PN}-dev += "${datadir}/cmake/*"
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
