LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "automoc4-native giflib attica jpeg libpng bzip2 libpcre"

#soprano
#strigi-native
#libphonon-native
#DEPENDS_virtclass-native = "perl-native "

inherit mime perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Disable-documentation.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Fix-Qt-and-Phonon.patch \
	   file://0004-Fix-the-path-to-Icemaker.patch \
	  "

SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"


FILES_${PN} += "\
	  ${libdir}/kde4/*.so \
	  ${datadir}/apps/kauth/*.stub \
	 "

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

# as long as Qt4 native is broken we need our DIRTY HACK / WORKAROUND stuff here
EXTRA_OECMAKE =+ "\
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  \
		  -DDBUSMENUQT_INCLUDE_DIR=${STAGING_INCDIR}/QtDBus \
		  -DDBUSMENUQT_LIBRARIES=${OE_QMAKE_LIBDIR_QT} \
		  \
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		  \
		  -DICEMAKER_EXECUTABLE=${STAGING_BINDIR_NATIVE}/icemaker \
		  \
		  -DKDE_PREFIX=${TARGET_PREFIX} \
		 "

do_compile() {
  cd ${S}/build/kdecore && oe_runmake CC="${CC}" CXX="${CXX}"
}

do_install() {
#  install -d ${D}/${libdir}
#  for i in ${S}/build/lib/*
#  do
#    install -m 0755 ${i} ${D}/${libdir}
#  done
  cd ${S}/build/kdecore && oe_runmake PREFIX=${D} DESTDIR=${D} INSTALL_ROOT=${D} install
  install -m 0644 ${S}/build/kdemacros.h ${STAGING_INCDIR}
  cd ${S}/build/includes && oe_runmake install DESTDIR=${D}
}

#PARALLEL_MAKE=""
#BBCLASSEXTEND = "native"
