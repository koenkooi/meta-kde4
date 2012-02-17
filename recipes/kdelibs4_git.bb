LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"


DEPENDS = "kdelibs4-native kdelibs4-helper automoc4-native strigi giflib attica jpeg libpng bzip2 libpcre perl-native docbook-utils-native"

#soprano

inherit mime perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Don-t-build-documentation-disable-Strigi.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Fix-Qt-Phonon-and-kconfig_compiler.patch \
	   file://0004-Fix-the-path-to-Icemaker.patch \
	   file://0005-Remove-docs-so-they-don-t-get-pulled-in-elsewhere.patch \
	  "


SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"


FILES_${PN} += "\
	  ${libdir}/kde4/*.so \
	  ${datadir}/apps/kauth/*.stub \
	 "

FILES_${PN}-dev += "\
		   ${datadir}/apps/cmake/modules/* \
		  "

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

OECMAKE_CXX_FLAGS += " -I${STAGING_INCDIR}/qt4/QtCore"

EXTRA_OECMAKE =+ "\
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		  \
		  -DICEMAKER_EXECUTABLE=${STAGING_BINDIR_NATIVE}/icemaker \
		  \
		  -DPERL_LIBDIR=${STAGING_LIBDIR}/perl \
		  -DBZIP2_NEED_PREFIX=TRUE \
		  -DNEPOMUK_LIBRARIES=${STAGING_LIBDIR} \
		  -DNEPOMUK_QUERY_LIBRARIES=${STAGING_LIBDIR} \
		  \
		  -DKDE4_INSTALL_DIR=${D}${prefix} \
		 "



#PARALLEL_MAKE=""
