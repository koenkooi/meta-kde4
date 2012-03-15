LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4"

inherit kde_cmake kde_without_docs perlnative

SRC_URI = "git://anongit.kde.org/kcalc;protocol=git;tag=v4.8.0 \
	   file://Make-docs-optional.patch"
SRCREV = "f4cfedb09e5888801055e4464fc15afb2cdd5550"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${libdir}/libkdeinit4_kcalc.so \
		\
		${datadir}/* \
	       "