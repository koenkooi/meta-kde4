SUMMARY = "A WebKit based web browser for KDE"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "kdelibs4 automoc4-native"

RDEPENDS_${PN} = "libqtwebkit4"

inherit kde_cmake kde_rdepends kde_without_docs

SRC_URI = "git://anongit.kde.org/rekonq.git;protocol=git;branch=master"

## Tag 0.9.61
SRCREV = "ad43da132541f81e38f75c102dc72b476b0677dd"

PV = "0.9.61+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/libkdeinit4_rekonq.so \
    ${datadir}"
