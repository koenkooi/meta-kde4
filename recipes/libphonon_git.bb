LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "automoc4"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/phonon.git;protocol=git;branch=master \
	   file://0001-Patch-out-Qt-visibility-check.patch \
	  "
SRCREV = "b93727e0eac9faeaf073e60d2d6799d39a17ae23"

PV = "4.6.0+git${SRCPV}"

S = "${WORKDIR}/git" 

#we don't need experimental stuff
EXTRA_OECMAKE = "\
		 -DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
		 -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
		 -DQT_INCLUDE_DIR=${STAGING_INCDIR}/Qt \
		 -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
		 -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
		 -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
		 -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
		 -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
		 -DQT_QTCORE_INCLUDE_DIR=${STAGING_INCDIR}/QtCore \
		 -DQT_QT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/Qt \
		 \
		 -DPHONON_BUILD_EXPERIMENTAL=OFF \
		 "


BBCLASSEXTEND = "native" 