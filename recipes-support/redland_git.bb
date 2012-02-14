LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit autotools

SRC_URI = "git://github.com/dajobe/librdf.git;branch=master \
	   file://No-docs-and-NOCONFIGURE.patch \
	  "
SRCREV = "96e715aaccd86a8fb8fd00276aa973cd35ebe683"

PV = "1.0.15+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-gtk-doc"

# Redland autogen.sh does not work properly, so let OE do the job
do_configure() {
	cd ${S}
#	touch gtk-doc.make
	export NOCONFIGURE="no"; ./autogen.sh
	oe_runconf
}
