LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "automoc4-native"

require kde4.inc

SRC_URI = "git://anongit.kde.org/phonon.git;protocol=git;branch=master \
	   file://0001-Patch-out-Qt-visibility-check.patch \
	  "
SRCREV = "b93727e0eac9faeaf073e60d2d6799d39a17ae23"

PV = "4.6.0+git${SRCPV}"

S = "${WORKDIR}/git"

#we don't need experimental stuff
EXTRA_OECMAKE += "\
		 -DPHONON_BUILD_EXPERIMENTAL=OFF \
		 \
		 -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		 \
		 "


BBCLASSEXTEND = "native"