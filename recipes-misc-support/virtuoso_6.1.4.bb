LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit autotools

DEPENDS = "openssh"

SRC_URI = "http://netcologne.dl.sourceforge.net/project/virtuoso/virtuoso/6.1.4/virtuoso-opensource-6.1.4.tar.gz \
	   file://fix-weird-md5-error.diff \
	   file://config-cross.diff \
	   file://build-sanely.diff \
	  "

SRC_URI[md5sum] = "7110a0b4b171b84850d346f4fe648172"
SRC_URI[sha256sum] = "153f92211a23e05dcf4bde4c94d2963d06321d00f213c50025d740b96140154e"



EXTRA_OECONF =+ "\
		 --disable-all-vads \
		 --disable-openldap \
		 --disable-wbxml2 \
		 --disable-imsg \
		 --disable-hslookup \
	        "



S = "${WORKDIR}/${BPN}-opensource-${PV}"
