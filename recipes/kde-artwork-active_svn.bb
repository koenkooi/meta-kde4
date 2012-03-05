LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://splash/main.qml;beginline=2;endline=18;md5=ab5c18ec5cfda84f5423a5ebe94dcb01"

#inherit qt4x11 cmake
require kde4.inc

SRC_URI = "svn://anonsvn.kde.org/home/kde;module=trunk/playground/base/plasma/kde-artwork-active;proto=svn"
SRCREV = "1266939"

PV = "0.2+svnr${SRCPV}"

S = "${WORKDIR}/trunk/playground/base/plasma/kde-artwork-active/"

FILES_${PN} += "\
		${datadir}/apps/ksplash/* \
		${datadir}/apps/kscreenlocker/* \
		${datadir}/wallpapers/* \
	       "

## DIRTY HACK / WORKAROUND
do_install_append() {
# This moves the wrong directory to the normal prefix
  mv -nf ${D}${STAGING_DIR_TARGET}/usr/share/* ${D}/usr/share/

# The next 2 lines will remove empty leftover directories
  tmp_relative_staging_dir_target=`echo "${STAGING_DIR_TARGET}" | sed 's|^/||'`
  cd ${D} && rmdir -p ${tmp_relative_staging_dir_target}/usr/share/
}
