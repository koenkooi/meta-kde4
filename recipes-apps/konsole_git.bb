LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4 kde-baseapps"

RDEPENDS_${PN} = "kde-baseapps"

inherit kde-without-docs kde-cmake

SRC_URI = "git://anongit.kde.org/konsole.git;protocol=git;tag=v4.8.0\ 
	   file://Make-docs-optional.patch"
SRCREV = "37a52f48ebd4850d07cd8fe7277e6fa7a653c2ae"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${libdir}/kde4/*.so \
		${libdir}/libkdeinit4_konsole.so \
		${libdir}/libkonsoleprivate.so \
		\
		${datadir}/* \
	       "


FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
