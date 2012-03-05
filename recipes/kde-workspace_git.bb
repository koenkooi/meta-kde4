LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

require kde4.inc
inherit perlnative

DEPENDS = "kdelibs4 qimageblitz libxkbfile perl-native boost soprano shared-desktop-ontologies"

SRC_URI = "git://anongit.kde.org/kde-workspace;protocol=git;tag=v4.7.4 \
	   file://Disable-docs.patch \
	   file://Fix-Phonon-to-phonon-include-naming-sheme.patch \
	   file://Opt-out-python-scriptengine.patch"


SRCREV = "4a09a209faecf9a209eff3ac9e8b8238db64e317"

PV = "4.7.4+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${libdir}/libkdeinit4_kaccess.so \
		${libdir}/libkdeinit4_kcminit.so \
		${libdir}/libkdeinit4_kcminit_startup.so \
		${libdir}/libkdeinit4_klipper.so \
		${libdir}/libkdeinit4_kmenuedit.so \
		${libdir}/libkdeinit4_krunner.so \
		${libdir}/libkdeinit4_ksmserver.so \
		${libdir}/libkdeinit4_ksysguard.so \
		${libdir}/libkdeinit4_kwin.so \
		${libdir}/libkdeinit4_kwin_rules_dialog.so \
		${libdir}/libkdeinit4_plasma-desktop.so \
		${libdir}/libkdeinit4_plasma-netbook.so \
		${libdir}/libkdeinit4_plasma-windowed.so \
		${libdir}/libkickoff.so \
		${libdir}/libpowerdevilui.so \
		${libdir}/kde4/*.so \
		${libdir}/kde4/plugins/*/*.so \
		${libdir}/kde4/libexec/* \
		${libdir}/strigi/strigita_font.so \
		\
		${datadir}/apps/* \
		${datadir}/config/* \
		${datadir}/config.kcfg/* \
		${datadir}/kde4/* \
		${datadir}/wallpapers/* \
		${datadir}/icons/* \
		${datadir}/autostart/* \
		${datadir}/dbus-1/* \
"

FILES_${PN}-dbg += "\
		    ${libdir}/kde4/.debug/* \
		    ${libdir}/kde4/libexec/.debug/* \
		    ${libdir}/kde4/plugins/*/.debug/* \
		    ${libdir}/strigi/.debug/strigita_font.so \
		   "

EXTRA_OECMAKE += "\
		  -DPHONON_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
		  -DWITHOUT_PYTHON=TRUE \
		  -DHONORS_SOCKET_PERMS_EXITCODE=0 \
		  -DKDE_WORKSPACE_WORKAROUND=TRUE"



## DIRTY HACK / WORKAROUND
do_install_append() {

# This will move dbus into the wrong directory to prevent mv error directory not empty
  mv ${D}/usr/share/* ${D}${STAGING_DIR_TARGET}/usr/share

# This moves the wrong directory to the normal prefix
  mv -nf ${D}${STAGING_DIR_TARGET}/usr/* ${D}/usr/

# The next 2 lines will remove empty leftover directories
  tmp_relative_staging_dir_target=`echo "${STAGING_DIR_TARGET}" | sed 's|^/||'`
  cd ${D} && rmdir -p ${tmp_relative_staging_dir_target}/usr
}

# WORKAROUND alternative, do it with sed
#do_install_prepend() {
#  for i in `find ${S}/build/ -name '*.make'`; do
#      sed -i 's|${STAGING_DIR_TARGET}${prefix}|/usr/|' ${i}
#  done
#}


# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
