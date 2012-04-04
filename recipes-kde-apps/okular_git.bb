LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "kdelibs4"

inherit kde_cmake kde_rdepends kde_without_docs

SRC_URI = "git://anongit.kde.org/okular.git;protocol=git;tag=v4.8.0 \
	   file://Don-t-install-cmake-files-to-the-libdir.patch \
	   file://Fix-Phonon-to-phonon.patch"
SRCREV = "aa0396030c0e4ad80f122824b0699ccd76e719dd"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${libdir}/kde4/*.so \
		\
		${datadir}/ \
		${datadir}/apps/okular/* \
		${datadir}/config.kcfg \
		${datadir}/kde4/* \
		${datadir}/icons/* \
	       "

FILES_${PN}-dev += "${datadir}/apps/cmake/*"

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"