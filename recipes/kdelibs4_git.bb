LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"


DEPENDS = "automoc4-native strigi giflib attica jpeg libpng bzip2 libpcre perl-native"

#soprano

inherit mime perlnative kde-exports
require kde4.inc

SRC_URI = "git://anongit.kde.org/kdelibs.git;tag=v4.7.4 \
	  file://0001-Don-t-build-documentation-disable-Strigi.patch \
	  file://0002-Fix-openssl-check.patch \
	  file://0003-Fix-FindKDE4Internals-cmake-file.patch \
	  file://0004-Fix-the-path-to-Icemaker.patch \
	  file://0005-Remove-docs-so-they-don-t-get-pulled-in-elsewhere.patch \
	  file://0006-Fix-makekdewidget-executable-path.patch \
	  "

SRCREV = "bd4af4938a23585fd6443193935c170739d12822"
PV = "4.7.4+git${SRCPV}"

S = "${WORKDIR}/git"

KDE_EXPORT_FILES = "${S}/build/CMakeFiles/Export/_usr/share/apps/cmake/modules/KDELibs4LibraryTargets-relwithdebinfo.cmake ${S}/build/KDELibsDependencies.cmake"

FILES_${PN} += "\
	  ${datadir}/apps/kauth/*.stub \
	 "

FILES_${PN}-dev += "\
		   ${libdir}/kde4/*.so \
		   ${datadir}/apps/cmake/modules/* \
		  "

##		   ${incdir}/nepomuk/tools.h

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

#do_install_append() {
#  install -d ${D}${incdir}/nepomuk/
#  install -m 0644 ${S}/nepomuk/core/tools.h ${D}${incidr}/nepomuk/tools.h
#}


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

##		  -DKDE_PLATFORM_PROFILE=Mobile \

#PARALLEL_MAKE=""
