LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "automoc4-native giflib-native attica-native"

#strigi-native
#soprano
# jpeg libpng bzip2
DEPENDS_virtclass-native = "perl-native "

inherit mime native perlnative
require kde4-native.inc

SRC_URI = "git://anongit.kde.org/kdelibs;protocol=git;branch=master \
	   file://0001-Don-t-build-documentation-disable-Strigi.patch \
	   file://0002-Fix-openssl-check.patch \
	   file://0003-Fix-Qt-Phonon-and-kconfig_compiler.patch \
	  "

SRCREV = "cc5bf952ad182cf049e5df02c4c5f09d62bb68a2"
PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git"

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


EXTRA_OECMAKE =+ "\
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		  -DSTRIGI_INCLUDE_DIR=TRUE \
		 "

do_compile() {
  cd ${S}/build
  make -C kdecore/kconfig_compiler
  make -C kjs icemaker
}

do_install() {
  install -d ${D}${bindir}
  
  install -m 0755 ${S}/build/bin/icemaker ${D}${bindir}
  install -m 0755 ${S}/build/bin/kconfig_compiler ${D}${bindir}
}
