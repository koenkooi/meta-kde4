LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"


DEPENDS = "automoc4-native strigi giflib attica jpeg libpng bzip2 libpcre perl-native"

#soprano

inherit mime perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs.git;branch=v4.7.4 \
	  file://0001-Don-t-build-documentation-disable-Strigi.patch \
	  file://0002-Fix-openssl-check.patch \
	  file://0003-Fix-FindKDE4Internals-cmake-file.patch \
	  file://0004-Fix-the-path-to-Icemaker.patch \
	  file://0005-Remove-docs-so-they-don-t-get-pulled-in-elsewhere.patch \
	  file://0006-Fix-makekdewidget-executable-path.patch \
	  "

SRCREV = "0e296a6d0d6b4b5e20c0f9fcb7fe831e7409df87"
PV = "4.7.4+git${SRCPV}"

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

#OECMAKE_CXX_FLAGS += " -I${STAGING_INCDIR}/qt4/QtCore -L${STAGING_LIBDIR}"

EXTRA_OECMAKE =+ "\
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		  \
		  -DICEMAKER_EXECUTABLE=${STAGING_BINDIR_NATIVE}/icemaker \
		  \
		  -DPERL_LIBDIR=${STAGING_LIBDIR}/perl \
		  -DBZIP2_NEED_PREFIX=TRUE \
		  \
		  -DKDE4_INSTALL_DIR=${D}${prefix} \
		 "



#PARALLEL_MAKE=""
