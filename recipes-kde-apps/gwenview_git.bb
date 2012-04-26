SUMMARY = "KDE standard image viewer"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5a3169a2d39a757efd8b7aa66a69d97b"

DEPENDS = "kdelibs4 automoc4-native exiv2"
# for videos?
RDEPENDS = "libqtphonon4"

inherit kde_cmake kde_rdepends kde_without_docs

SRC_URI = "git://anongit.kde.org/gwenview.git;branch=master \
    file://0001-Without-docs.patch \
    file://0002-Fix-Phonon-to-phonon-in-includes.patch"

## Tag 4.8.0
SRCREV = "043cb5a4338c9880a0aefaafa669b9eefe564ff1"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir} \
    ${libdir}/kde4/*.so"

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*.so"