LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "automoc4-native giflib attica jpeg libpng soprano libphonon"
#strigi-native
DEPENDS_virtclass-native = "perl-native"

inherit qt4x11 cmake mime native perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Disable-documentation.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Disable-Phonon.patch \
	  "

SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

# as long as Qt4 native is broken we need our DIRTY HACK / WORKAROUND stuff here
EXTRA_OECMAKE =+ "\
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  \
		  -DQT_QT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/Qt \
		  \
		  -DDBUSMENUQT_INCLUDE_DIR=${STAGING_INCDIR}/QtDBus \
		  -DDBUSMENUQT_LIBRARIES=${OE_QMAKE_LIBDIR_QT} \
		  \
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		 "

#possible QT_INCLUDE_DIR paths: ${STAGING_INCDIR}/Qt:${STAGING_INCDIR}/Qt3Support:${STAGING_INCDIR}/QtCore:${STAGING_INCDIR}/QtDBus:${STAGING_INCDIR}/QtGui:${STAGING_INCDIR}/QtNetwork:${STAGING_INCDIR}/QtSql ${STAGING_INCDIR}/QtTest:${STAGING_INCDIR}/QtXml:${STAGING_INCDIR}/QtXmlPatterns



PARALLEL_MAKE=""
BBCLASSEXTEND = "native"
