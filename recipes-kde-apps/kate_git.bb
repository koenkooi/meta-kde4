LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://kate/COPYING.LIB;md5=156642aa865c263a96e2cdd7a5cc8570"

DEPENDS = "kdelibs4"

inherit kde_cmake perlnative

SRC_URI = "git://anongit.kde.org/kate;protocol=git;tag=v4.8.0"
SRCREV = "a90b84b2c07181044a61199e707e40cbb3d0db18"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

# kate *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

FILES_${PN} += "\
		${libdir}/kde4/*.so \
		${libdir}/libkdeinit4_kate.so \
		${libdir}/libkdeinit4_kwrite.so \
		\
		${datadir}/* \
	       "

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
