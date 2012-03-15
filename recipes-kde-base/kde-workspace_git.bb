LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit kde_cmake kde_without_docs perlnative

#if you use x86 replace virtual/egl with virtual/gl
DEPENDS = "kdelibs4 libkactivities4 qimageblitz libxkbfile perl-native boost soprano shared-desktop-ontologies virtual/egl"
RDEPENDS_${PN} = "libkactivities4 soprano"

SRC_URI = "git://anongit.kde.org/kde-workspace;protocol=git;tag=v4.8.0 \
	   file://Fix-Phonon-to-phonon-include-naming-sheme.patch \
	   file://Opt-out-python-scriptengine.patch"


SRCREV = "0ad49f2e4392b75ce16c5a08dcac99caf8cabe0d"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

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
		${datadir}/icons/* \
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
