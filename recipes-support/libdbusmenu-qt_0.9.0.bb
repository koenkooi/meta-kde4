LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=db979804f025cf55aabec7129cb671ed"

inherit qt4x11 cmake

DEPENDS = "dbus"

SRC_URI = "https://launchpad.net/libdbusmenu-qt/trunk/0.9.0/+download/libdbusmenu-qt-0.9.0.tar.bz2 \
	   file://WORKAROUND-export-visibility.patch \
	   file://Fix_test_build.patch \
	  "

SRC_URI[md5sum] = "cc6b7b551377e2a07f6fa5afef0d29ff"
SRC_URI[sha256sum] = "071d8215c17999cdef8f8361964b45e135edf96c955d6618f4ebf1eac662b175"


# The tests need QJSON to build
EXTRA_OECMAKE =+ "\
		  -DWITH_DOC=FALSE \
		  -DBUILD_TESTS=FALSE \
		 "


BBCLASSEXTEND = "native"
