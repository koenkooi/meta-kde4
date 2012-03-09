LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=33ae76b97623009161dae781083a4874"

inherit kde-workaround-tmp
require kde4.inc

DEPENDS = "soprano shared-desktop-ontologies kdelibs4 libkactivities4"

RDEPENDS_${PN} = "plasma-contour-config shared-desktop-ontologies"

SRC_URI = "git://anongit.kde.org/contour.git;branch=master"

SRCREV = "24b721c30aa36943e17ecc5ab2617ff4bc67cb2a"

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

PV = "Active-Two+git${SRCPV}"

S = "${WORKDIR}/git"
