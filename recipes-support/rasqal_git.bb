LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit autotools

DEPENDS = "raptor"

SRC_URI = "git://github.com/dajobe/rasqal.git;branch=master \
	   file://No-docs-and-NOCONFIGURE.patch \
	  "

SRCREV = "b4a51b51731b0d54eface8996a7aed467c533d18"

PV = "0.9.28+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OECONF = "\
		--with-regex-library=posix \
		--with-decimal=gmp \
		--enable-maintainer-mode \
	       "

# Redland autogen.sh does not work properly, so let OE do the job
do_configure() {
	cd ${S}
#	touch gtk-doc.make
	export NOCONFIGURE="no"; ./autogen.sh
	oe_runconf
}
