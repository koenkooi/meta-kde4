LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit kde_cmake kde_without_docs kde_rdepends perlnative

# Gracefully depend on virtual/egl if needed.
STDDEPENDS = "kdelibs4 libkactivities4 qimageblitz libxkbfile perl-native boost soprano"
DEPENDS = "${STDDEPENDS} virtual/libgl"
DEPENDS_omap3 = "${STDDEPENDS} virtual/egl"

# Builds will behave differently when libgl or egl is used
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "libkactivities4 soprano"
RRECOMMENDS_${PN} = "setxkbmap"

SRC_URI = "git://anongit.kde.org/kde-workspace;protocol=git;branch=master \
	   file://Fix-Phonon-to-phonon-include-naming-sheme.patch \
	   file://Opt-out-python-scriptengine.patch \
	   file://Fix-path-to-X11-libraries.patch"

## Tag v4.8.0
SRCREV = "e80df74d9936428001d630a8a927c908507b2e1f"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

do_install_prepend() {
# KDE needs "real" cross compiling support, but this works for now
  echo "Replace messed up binary path in the startkde script"
  sed -i "s|${STAGING_DIR_TARGET}||" ${S}/build/startkde
}

PACKAGES =+ "\
	     ${PN}-cursors-oxygen-black \
	     ${PN}-cursors-oxygen-blue \
	     ${PN}-cursors-oxygen-white \
	     ${PN}-cursors-oxygen-yellow \
	     ${PN}-cursors-oxygen-zion \
	    "


FILES_${PN} += "\
		${libdir}/libkdeinit4_*.so \
		${libdir}/libkickoff.so \
		${libdir}/libpowerdevilui.so \
		${libdir}/kde4/*.so \
		${libdir}/kde4/plugins/*/*.so \
		${libdir}/kde4/libexec/* \
		${libdir}/strigi/strigita_font.so \
		${libdir}/kconf_update_bin/kwin_* \
		${libdir}/kconf_update_bin/plasma-* \
		${libdir}/kconf_update_bin/krdb_clearlibrarypath \
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
		    ${libdir}/strigi/.debug/strigita_font.so \
		    ${libdir}/libpowerdevilui.so \
		    ${libdir}/kconf_update_bin/.debug/* \
		   "

FILES_${PN}-dev += "${datadir}/cmake/*"

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
