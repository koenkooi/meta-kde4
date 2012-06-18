LICENSE = "other"
LIC_FILES_CHKSUM = "file://../COPYING;md5=04e38b5b333181d76524f6371acaf652"

SRC_URI = "ftp://ftp.kde.org/pub/kde/stable/active/2.0/src/plasma-contour-config-0.2.13.tar.bz2 \
	   file://COPYING"

DEPENDS = "contour"

RPROVIDES_${PN} = "virtual/plasma-active-startscript"
RCONFLICTS_${PN} = "virtual/plasma-startscript"

SRC_URI[md5sum] = "f0f24f3847c86d2e4c2b255562ce106b"
SRC_URI[sha256sum] = "3081fbc28452ff4d63a28a0ae07da1505d461672e6553c44a7c839271a957478"

FILES_${PN} += "${datadir}/*"

do_install() {
  # default configuration for the desktop
  install -d ${D}/etc/kde4/share/config
  install -m 0644 ${S}/*rc ${D}/etc/kde4/share/config
  install -m 0644 ${S}/kdeglobals ${D}/etc/kde4/share/config
  install -m 0644 ${S}/lowspacesuse ${D}/etc/kde4/share/config

  # start plasma-mobile instead of plasma-desktop
  install -d ${D}/etc/kde4/Autostart
  install -m 0644 ${S}/*.desktop ${D}/etc/kde4/Autostart

  install -d ${D}/usr/share/autostart
  install -m 0644 ${S}/*.desktop ${D}/usr/share/autostart

  # launchers
  #install -d ${D}/usr/share/kde4/config/SuSE/default/tablet
  #install -m 0644 ${S}/launchers/*.desktop ${D}/usr/share/kde4/config/SuSE/default/tablet

  install -d ${D}/usr/share/apps/plasma-device/howto
  install -m 0644 ${S}/howto/* ${D}/usr/share/apps/plasma-device/howto
}
