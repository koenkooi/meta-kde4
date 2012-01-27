LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "automoc4 giflib attica jpeg libpng soprano libphonon"
#strigi native
DEPENDS_virtclass-native = "perl-native"

inherit qt4x11 cmake mime native perlnative


SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Disable-documentation.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Disable-Phonon.patch \
	  "
#	   file://0001-Fix-KDE-dependency-HELL.patch \

SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

# for some reason cmake can't find the qt stuff
EXTRA_OECMAKE = "\
		 -DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
                 -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
		 -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
		 -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
		 -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
		 -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
		 -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
		 -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
		 -DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \
		 \
		 -DQT_DBUSXML2CPP_EXECUTABLE=/usr/bin/qdbusxml2cpp \
		 -DQT_DBUSCPP2XML_EXECUTABLE=/usr/bin/qdbuscpp2xml \
		 \
		 -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		 \
		 -DQT_QT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/Qt \
		 \
		 -DDBUSMENUQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
		 -DDBUSMENUQT_LIBRARIES=${OE_QMAKE_LIBDIR_QT} \
		 \
		 -DKJS_FORCE_DISABLE_PCRE=TRUE \
		 -DSTRIGI_REQUIRED=FALSE \
		 \
		"


###		 -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
#possible dirs: ${STAGING_INCDIR}/Qt ${STAGING_INCDIR}/Qt3Support ${STAGING_INCDIR}/QtCore ${STAGING_INCDIR}/QtDBus ${STAGING_INCDIR}/QtGui ${STAGING_INCDIR}/QtNetwork ${STAGING_INCDIR}/QtSql ${STAGING_INCDIR}/QtTest ${STAGING_INCDIR}/QtXml ${STAGING_INCDIR}/QtXmlPatterns


do_install_append() {
	install -d ${D}/${libdir}/qt4
	mv ${D}/${STAGING_DIR_TARGET}/qt4/plugins* ${D}/${libdir}/qt4 || true
}

FILES_${PN} += "${libdir}/qt4 \
                ${datadir}/mime/packages \
		${datadir}/dbus-1 \
		${datadir}/config \
               "

FILES_${PN}-dbg += "${libdir}/qt4/.debug \
                    ${libdir}/qt4/*/.debug \
		    ${libdir}/qt4/*/*/.debug"

BBCLASSEXTEND = "native"