LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c12061335e5c8e8f63351ebe203b0e44"

inherit autotools

SRC_URI = "http://www.iodbc.org/downloads/iODBC/libiodbc-3.52.7.tar.gz \
	  "

SRC_URI[md5sum] = "ddbd274cb31d65be6a78da58fc09079a"
SRC_URI[sha256sum] = "d7002cc7e566785f1203f6096dcb49b0aad02a9d9946a8eca5d663ac1a85c0c7"

EXTRA_OECONF =+ "\
		 --disable-gui \
	        "
