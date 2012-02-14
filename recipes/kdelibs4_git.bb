LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"


DEPENDS = "kdelibs4-native kdelibs4-helper automoc4-native strigi giflib attica jpeg libpng bzip2 libpcre perl-native docbook-utils-native"

#soprano
#strigi-native
#libphonon-native

inherit mime perlnative
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Don-t-build-documentation-disable-Strigi.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Fix-Qt-Phonon-and-kconfig_compiler.patch \
	   file://0004-Fix-the-path-to-Icemaker.patch \
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

OECMAKE_CXX_FLAGS += " -I${STAGING_INCDIR}"

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
		  -DPERL_LIBDIR=${STAGING_LIBDIR}/perl \
		  -DBZIP2_NEED_PREFIX=TRUE \
		  -DNEPOMUK_LIBRARIES=${STAGING_LIBDIR} \
		  -DNEPOMUK_QUERY_LIBRARIES=${STAGING_LIBDIR} \
		 "

do_compile() {
  cd ${S}/build/kdecore && oe_runmake CC="${CC}" CXX="${CXX}"
}

do_install() {
# Install CMake files and includes
  install -d ${D}${datadir}/apps/cmake/modules
  cd ${S}/build/cmake && oe_runmake install DESTDIR=${D}
  cd ${S}/build/includes && oe_runmake install DESTDIR=${D}

# This cmake file is malicious because it has hardcoded string constants in there pointing to /usr/.. instead of .../sysroot/.../usr !!
##install -m 0755 ${S}/build/KDELibsDependencies.cmake ${D}${datadir}/apps/cmake/modules

  install -m 0755 ${S}/build/KDEPlatformProfile.cmake ${D}${datadir}/apps/cmake/modules

# Install the core library and a stray include file
  cd ${S}/build/kdecore && oe_runmake install DESTDIR=${D}
  install -m 0644 ${S}/build/kdemacros.h ${STAGING_INCDIR}
}

#PARALLEL_MAKE=""
