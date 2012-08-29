LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit kde_cmake kde_exports kde_without_docs kde_rdepends perlnative

DEPENDS = "kdelibs4-native automoc4-native soprano-native strigi libdbusmenu-qt soprano shared-desktop-ontologies dbus giflib jasper attica jpeg libpng bzip2 libpcre perl-native aspell"
RRECOMMENDS_${PN} = "jasper jpeg libpng giflib"

SRC_URI = "git://anongit.kde.org/kdelibs.git;branch=master \
    file://0001-Disable-doctools.patch \
    file://0002-Fix-openssl-check.patch \
    file://0003-Fix-FindKDE4Internals-cmake-file.patch \
    file://0004-Fix-the-path-to-Icemaker.patch \
    file://0006-Fix-makekdewidget-executable-path.patch \
    "

#     file://0003-Fix-FindKDE4Internals-cmake-file.patch \

## Tag v4.9.0
SRCREV = "bfdb17858efeeabf74ccb4a4010e250bcde6aa42"
PV = "4.9.0+git${SRCPV}"

PR = "r1"

S = "${WORKDIR}/git"

KDE_EXPORT_FILES = "${S}/build/CMakeFiles/Export/_usr/share/apps/cmake/modules/KDELibs4LibraryTargets-relwithdebinfo.cmake \
${S}/build/KDELibsDependencies.cmake \
${S}/build/experimental/libkdeclarative/CMakeFiles/Export/_usr/lib/cmake/KDeclarative/KDeclarativeLibraryTargets-relwithdebinfo.cmake"

FILES_${PN} =+ "\
    ${libdir}/libkdeinit4_*.so \
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/libexec/* \
    ${libdir}/kde4/plugins/designer/* \
    ${libdir}/kde4/plugins/imageformats/* \
    ${libdir}/kde4/plugins/kauth/* \
    ${libdir}/kde4/plugins/script/*.so.* \
    \
    ${datadir}/apps/* \
    ${datadir}/config/* \
    ${datadir}/mime/* \
    ${datadir}/kde4/* \
    ${datadir}/icons/* \
    ${datadir}/dbus-1/* \
    \
    ${sysconfdir}/* \
    "


# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""

FILES_${PN}-dev += "\
    ${bindir}/kconfig_compiler \
    ${bindir}/kde4-config \
    \
    ${datadir}/apps/cmake/* \
    ${libdir}/cmake/KDeclarative/*.cmake \
    \
    ${libdir}/kde4/plugins/script/libkrossqtsplugin.so \
    \
    \
    ${libdir}/libkcmutils.so \
    ${libdir}/libkde3support.so \
    ${libdir}/libkdeclarative.so \
    ${libdir}/libkdecore.so \
    ${libdir}/libkdefakes.so \
    ${libdir}/libkdesu.so \
    ${libdir}/libkdeui.so \
    ${libdir}/libkdewebkit.so \
    ${libdir}/libkdnssd.so \
    ${libdir}/libkemoticons.so \
    ${libdir}/libkfile.so \
    ${libdir}/libkhtml.so \
    ${libdir}/libkidletime.so \
    ${libdir}/libkimproxy.so \
    ${libdir}/libkio.so \
    ${libdir}/libkjs.so \
    ${libdir}/libkjsapi.so \
    ${libdir}/libkjsembed.so \
    ${libdir}/libkmediaplayer.so \
    ${libdir}/libknewstuff2.so \
    ${libdir}/libknewstuff3.so \
    ${libdir}/libknotifyconfig.so \
    ${libdir}/libkntlm.so \
    ${libdir}/libkparts.so \
    ${libdir}/libkprintutils.so \
    ${libdir}/libkpty.so \
    ${libdir}/libkrosscore.so \
    ${libdir}/libkrossui.so \
    ${libdir}/libktexteditor.so \
    ${libdir}/libkunitconversion.so \
    ${libdir}/libkunittest.so \
    ${libdir}/libkutils.so \
    ${libdir}/libnepomuk.so \
    ${libdir}/libnepomukquery.so \
    ${libdir}/libnepomukutils.so \
    ${libdir}/libplasma.so \
    ${libdir}/libsolid.so \
    ${libdir}/libthreadweaver.so \
    "

FILES_${PN}-dbg += "\
    ${libdir}/kde4/.debug/* \
    ${libdir}/kde4/*/.debug/* \
    ${libdir}/kde4/*/*/.debug/* \
    ${libdir}/kde4/*plugins/kauth/helper/.debug/* \
    ${libdir}/kde4/plugins/kauth/backend/.debug/* \
    "

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

# OE_CROSSCOMPILING is only set for applications that use kde, but not for kdelibs itself.
# This will prevent errors when the cmake macro _set_fancy is required by other cmake files while compiling kdelibs.
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
    -DOE_CROSSCOMPILING=FALSE \
    "

# This will cause errors related to disabled DEPRECATED settings (e.g. usr/include/nepomuk/tools.h will be missing but is required)
##  -DKDE_PLATFORM_PROFILE=Mobile \
