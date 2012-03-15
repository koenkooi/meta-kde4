LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit kde-cmake

DEPENDS = "kde-workspace kde-runtime soprano shared-desktop-ontologies kdelibs4 libkactivities4"

RDEPENDS_${PN} = "plasma-contour-config kde-runtime shared-desktop-ontologies soprano libkactivities4"

RRECOMMENDS_${PN} = "kde-wallpapers"

SRC_URI = "git://anongit.kde.org/contour.git;branch=master"
SRCREV = "24b721c30aa36943e17ecc5ab2617ff4bc67cb2a"

PV = "Active-Two+git${SRCPV}"
S = "${WORKDIR}/git"

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
