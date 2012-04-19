LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit autotools gtk-doc

DEPENDS = "raptor"
RDEPENDS_${PN} = "raptor"

SRC_URI = "git://github.com/dajobe/rasqal.git;branch=master \
	   file://No-docs-and-NOCONFIGURE.patch \
	   file://Fix-cross-compile.patch \
	  "

SRCREV = "ffc5f88dcaa20b279a39b537db1c65019003b16d"

PV = "0.9.27+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OECONF = "\
		--enable-maintainer-mode \
		--disable-gtk-doc \
		--with-regex-library=posix \
		--with-decimal=gmp \
	       "

# Rasqal autogen.sh does not work properly, so let OE do the job
do_configure() {
	cd ${S}
	export NOCONFIGURE="no"; ./autogen.sh
	oe_runconf
}
PARALLEL_MAKE = ""