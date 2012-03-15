LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4 soprano"

inherit kde-without-docs kde-cmake

SRC_URI = "git://anongit.kde.org/kde-baseapps;protocol=git;tag=v4.8.0 \
	   file://Convert-Phonon-to-phonon.patch"
SRCREV = "37a52f48ebd4850d07cd8fe7277e6fa7a653c2ae"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

FILES_${PN} += "\
		${libdir}/kde4/*.so \
		${libdir}/libkdeinit4*.so \
		\
		${datadir}/* \
	       "

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
