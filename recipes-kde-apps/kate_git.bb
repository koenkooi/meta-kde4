LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://kate/COPYING.LIB;md5=156642aa865c263a96e2cdd7a5cc8570"

DEPENDS = "kdelibs4"

inherit kde_cmake kde_without_docs kde_rdepends perlnative

SRC_URI = "git://anongit.kde.org/kate;protocol=git;branch=master"

## Tag 4.8.0
SRCREV = "78edc645422be447e7d451ed86e2fe690ae303e1"

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
