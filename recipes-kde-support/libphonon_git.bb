LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "automoc4-native"

inherit kde_cmake

SRC_URI = "git://anongit.kde.org/phonon.git;protocol=git;branch=master \
	   file://0001-Patch-out-Qt-visibility-check.patch \
	  "
## 2012/JAN/10 this SRCREV should be around the 4.8.0 tag time
SRCREV = "95db88df8510bcf26e3efa6f798732a79a9ecf72"

PV = "4.6.0+git${SRCPV}"

S = "${WORKDIR}/git"

#we don't need experimental stuff
EXTRA_OECMAKE += "\
		 -DPHONON_BUILD_EXPERIMENTAL=OFF \
		 \
		 -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		 \
		 "

FILES_${PN} += "${datadir}/dbus-1/"


BBCLASSEXTEND = "native"
