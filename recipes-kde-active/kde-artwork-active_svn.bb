LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://splash/main.qml;beginline=2;endline=18;md5=ab5c18ec5cfda84f5423a5ebe94dcb01"

DEPENDS = "kdelibs4"

inherit kde_cmake kde_rdepends

SRC_URI = "svn://anonsvn.kde.org/home/kde;module=trunk/playground/base/plasma/kde-artwork-active;proto=svn"
SRCREV = "1266939"

PV = "0.2+svnr${SRCPV}"

S = "${WORKDIR}/trunk/playground/base/plasma/kde-artwork-active/"

FILES_${PN} += "\
		${datadir}/apps/ksplash/* \
		${datadir}/apps/kscreenlocker/* \
		${datadir}/wallpapers/* \
	       "

