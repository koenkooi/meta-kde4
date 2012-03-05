LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=2;endline=17;md5=ab7ff4858efc6ddd5151e115b0bf2d9f"

#inherit qt4x11 cmake
require kde4.inc

FILES_${PN} += "\
		${bindir}/startactive.bin \
		${datadir}/apps/startactive/* \
		${datadir}/apps/startactive/modules/* \
		${datadir}/apps/ksplash/Themes/qmldefault/* \
		${datadir}/apps/ksplash/Themes/qmldefault/images/* \
	       "

FILES_${PN}-dbg += "${bindir}/.debug/*"

SRC_URI = "git://anongit.kde.org/startactive.git;branch=master"
SRCREV = "099221769e2b50e41c3ac920caa01afc711f3d6e"

PV = "Active-Two+git${SRCPV}"

S = "${WORKDIR}/git"

## DIRTY HACK / WORKAROUND
do_install_append() {
# This moves the wrong directory to the normal prefix
  mv -nf ${D}${STAGING_DIR_TARGET}/usr/bin/* ${D}/usr/bin/

# The next 2 lines will remove empty leftover directories
  tmp_relative_staging_dir_target=`echo "${STAGING_DIR_TARGET}" | sed 's|^/||'`
  cd ${D} && rmdir -p ${tmp_relative_staging_dir_target}/usr/bin
}
