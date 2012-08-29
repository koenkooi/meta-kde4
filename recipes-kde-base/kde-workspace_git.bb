LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit kde_cmake kde_without_docs kde_rdepends perlnative

# Gracefully depend on virtual/egl if needed.
STDDEPENDS = "kdelibs4 libkactivities4 qimageblitz libxkbfile perl-native boost soprano python"
DEPENDS = "${STDDEPENDS} virtual/libgl"
DEPENDS_omap3 = "${STDDEPENDS} virtual/egl"

# Builds will behave differently when libgl or egl is used
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "libkactivities4 soprano"
RRECOMMENDS_${PN} = "setxkbmap"

SRC_URI = "git://anongit.kde.org/kde-workspace;protocol=git;branch=master \
    file://Fix-Phonon-to-phonon-include-naming-sheme.patch \
    file://Fix-path-to-X11-libraries.patch"

## Tag v4.9.0
SRCREV = "df6a86044ffd3d8f02dc0b15348d3475338cad10"

PV = "4.9.0+git${SRCPV}"

PR = "r1"

S = "${WORKDIR}/git"

do_install_prepend() {
# KDE needs "real" cross compiling support, but this works for now
  echo "Replace messed up binary path in the startkde script"
  sed -i "s|${STAGING_DIR_TARGET}||" ${S}/build/startkde
}

PACKAGES =+ "\
    ${PN}-startkde \
    ${PN}-cursors-oxygen-black \
    ${PN}-cursors-oxygen-blue \
    ${PN}-cursors-oxygen-white \
    ${PN}-cursors-oxygen-yellow \
    ${PN}-cursors-oxygen-zion \
    "

PACKAGE_ARCH_${PN}-startkde = "allarch"
PACKAGE_ARCH_${PN}-cursors-oxygen-black = "allarch"
PACKAGE_ARCH_${PN}-cursors-oxygen-blue = "allarch"
PACKAGE_ARCH_${PN}-cursors-oxygen-white = "allarch"
PACKAGE_ARCH_${PN}-cursors-oxygen-yellow = "allarch"
PACKAGE_ARCH_${PN}-cursors-oxygen-zion = "allarch"

RPROVIDES_${PN}-startkde = "virtual/plasma-startscript"

FILES_${PN} += "\
    ${libdir}/libkdeinit4_*.so \
    ${libdir}/libkickoff.so \
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/plugins/*/*.so \
    ${libdir}/kde4/libexec/* \
    ${libdir}/strigi/strigita_font.so \
    ${libdir}/kconf_update_bin/kwin_* \
    ${libdir}/kconf_update_bin/plasma-* \
    ${libdir}/kconf_update_bin/krdb_clearlibrarypath \
    ${libdir}/python2.7 \
    \
    ${datadir}/apps/* \
    ${datadir}/config/* \
    ${datadir}/config.kcfg/* \
    ${datadir}/kde4/* \
    ${datadir}/wallpapers/* \
    ${datadir}/icons/oxygen/* \
    ${datadir}/icons/hicolor/* \
    ${datadir}/autostart/* \
    ${datadir}/dbus-1/* \
    \
    ${sysconfdir}/* \
    "

FILES_${PN}-dbg += "\
    ${libdir}/kde4/.debug/* \
    ${libdir}/kde4/libexec/.debug/* \
    ${libdir}/kde4/plugins/*/.debug/* \
    ${libdir}/strigi/.debug/* \
    ${libdir}/kconf_update_bin/.debug/* \
    "

# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""

FILES_${PN}-dev += "\
    ${datadir}/cmake/* \
    ${libdir}/cmake/KDE4Workspace/*.cmake \
    \
    \
    ${libdir}libkdecorations.so \
    ${libdir}libkephal.so \
    ${libdir}libkfontinst.so \
    ${libdir}libkfontinstui.so \
    ${libdir}libkscreensaver.so \
    ${libdir}libksgrd.so \
    ${libdir}libksignalplotter.so \
    ${libdir}libkwineffects.so \
    ${libdir}libkwinglesutils.so \
    ${libdir}libkwinglutils.so \
    ${libdir}libkworkspace.so \
    ${libdir}liblsofui.so \
    ${libdir}liboxygenstyle.so \
    ${libdir}liboxygenstyleconfig.so \
    ${libdir}libplasma-geolocation-interface.so \
    ${libdir}libplasma_applet-system-monitor.so \
    ${libdir}libplasmaclock.so \
    ${libdir}libplasmagenericshell.so \
    ${libdir}libpowerdevilconfigcommonprivate.so \
    ${libdir}libpowerdevilcore.so \
    ${libdir}libprocesscore.so \
    ${libdir}libprocessui.so \
    ${libdir}libsolidcontrol.so \
    ${libdir}libsolidcontrolifaces.so \
    ${libdir}libsystemsettingsview.so \
    ${libdir}libtaskmanager.so \
    ${libdir}libweather_ion.so \
    "

FILES_${PN}-startkde = "${bindir}/startkde"
FILES_${PN}-cursors-oxygen-black = "${datadir}/icons/Oxygen_Black/*"
FILES_${PN}-cursors-oxygen-blue = "${datadir}/icons/Oxygen_Blue/*"
FILES_${PN}-cursors-oxygen-white = "${datadir}/icons/Oxygen_White/*"
FILES_${PN}-cursors-oxygen-yellow = "${datadir}/icons/Oxygen_Yellow/*"
FILES_${PN}-cursors-oxygen-zion = "${datadir}/icons/Oxygen_Zion/*"

EXTRA_OECMAKE += "\
    -DPHONON_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
    -DWITHOUT_PYTHON=TRUE \
    -DHONORS_SOCKET_PERMS_EXITCODE=0 \
    -DKDE_WORKSPACE_WORKAROUND=TRUE \
    -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules/ \
    \
    -DSHAREDDESKTOPONTOLOGIES_FOUND=TRUE \
    -DSHAREDDESKTOPONTOLOGIES_ROOT_DIR=${STAGING_DATADIR}/ontology \
    "

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
