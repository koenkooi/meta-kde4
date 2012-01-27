LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master;tag=v2.6.0"
#SRCREV = "2f5381c4c449f5c0b1390f7eaf00ef9216f8b5fa"

PV = "2.6+git${SRCPV}"

# OE lacks some native qt4 tools, so we use the ones form the host :/
EXTRA_OECMAKE = "-DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
                 -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
		 -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
		 -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
		 -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
		 -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
		 -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
		 -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
		 -DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \
		 -DQT_DBUSXML2CPP_EXECUTABLE=/usr/bin/qdbusxml2cpp \
		 -DQT_DBUSCPP2XML_EXECUTABLE=/usr/bin/qdbuscpp2xml \
		"

S = "${WORKDIR}/git"