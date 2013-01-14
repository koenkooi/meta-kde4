SUMMARY = "KDE standard fonts for Plasma Desktop"
SECTION = "fonts"
LICENSE = "OFLv1.1"
LIC_FILES_CHKSUM = "file://COPYING-OFL;md5=83a15f691f0bf4f5301bad4dcd081bdd"
SRCREV = "c1b91aceae98ca24f00718ac4d5ce7e0d566f7d3"

SRC_URI = "git://anongit.kde.org/oxygen-fonts.git;branch=master"

S = "${WORKDIR}/git"

inherit allarch

# This is copied from ttf.inc in meta-oe
do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}${datadir}/fonts/truetype/ \;
}

PACKAGES = "${PN}"

RDEPENDS_${PN} = "fontconfig-utils"

FILES_${PN} += "${datadir}"

pkg_postinst_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ] ; then
        exit 1
fi
fc-cache -f
}
