

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit autotools

SRC_URI = "http://netcologne.dl.sourceforge.net/project/virtuoso/virtuoso/6.1.4/virtuoso-opensource-6.1.4.tar.gz "

SRC_URI[md5sum] = "7110a0b4b171b84850d346f4fe648172"
SRC_URI[sha256sum] = "153f92211a23e05dcf4bde4c94d2963d06321d00f213c50025d740b96140154e"

EXTRA_OECONF =+ "--disable-gtk-doc \
		 --with-layout=Debian \
		 --disable-all-vads \
	        "

S = ${WORKDIR}/${BPN}-opensource-${PV}

do_configure() {
	rm -f configure
	cd ${S}
#	touch gtk-doc.make
	export NOCONFIGURE="no"; ./autogen.sh
	oe_runconf
}
