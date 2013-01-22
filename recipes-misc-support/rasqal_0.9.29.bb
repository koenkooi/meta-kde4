LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "raptor"

SRC_URI = "http://download.librdf.org/source/${BPN}-${PV}.tar.gz \
    file://Fix-cross-compile.patch \
"
SRC_URI[md5sum] = "49e4b75a0c67465edf55dd20606715fa"
SRC_URI[sha256sum] = "8b218dc51b77b99f33103a9251218a4439748f73ee30fa8ee549ab6d150e7c53"

inherit autotools gtk-doc

EXTRA_OECONF = "\
    --disable-gtk-doc \
    --with-regex-library=posix \
    --with-decimal=gmp \
    "

RDEPENDS_${PN} = "raptor"

BBCLASSEXTEND = "native"

PARALLEL_MAKE = ""
