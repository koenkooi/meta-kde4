LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "automoc4-native giflib-native attica-native perl-native libdbusmenu-qt-native"

inherit kde_cmake kde_without_docs mime native perlnative

SRC_URI = "git://anongit.kde.org/kdelibs.git;branch=v4.8.0 \
	  file://0001-Don-t-build-documentation-disable-Strigi.patch \
	  file://0002-Fix-openssl-check.patch \
	  file://0003-Fix-FindKDE4Internals-cmake-file.patch \
	  file://0004-Fix-the-path-to-Icemaker.patch \
	  file://0005-Remove-docs-so-they-don-t-get-pulled-in-elsewhere.patch \
	  "

SRCREV = "1439483a67135f483632f4c4cd239e96d2ed61fc"
PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


EXTRA_OECMAKE =+ "\
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  -DKJS_FORCE_DISABLE_PCRE=TRUE \
		  -DSTRIGI_REQUIRED=FALSE \
		  -DSTRIGI_INCLUDE_DIR=TRUE \
		  -DOE_CROSSCOMPILING=FALSE \
		 "

do_compile() {
  cd ${S}/build && make -C kdecore/kconfig_compiler
  cd ${S}/build && make -C kjs icemaker
  cd ${S}/build && make -C kdewidgets makekdewidgets
}

do_install() {
  install -d ${D}${bindir}

  install -m 0755 ${S}/build/bin/icemaker ${D}${bindir}
  install -m 0755 ${S}/build/bin/kconfig_compiler ${D}${bindir}
  install -m 0755 ${S}/build/bin/makekdewidgets ${D}${bindir}
}
