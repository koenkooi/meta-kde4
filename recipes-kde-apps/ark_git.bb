SUMMARY = "KDE standard archive gui"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kdelibs4 automoc4-native "
## Tag 4.8.0
SRCREV = "0e67d6db9e7a5a0f90fcacaee11042b89b79d96b"
PV = "4.8.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/ark.git;branch=master \
    file://0001-Don-t-build-docs.patch"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends kde_without_docs

# for videos?
RDEPENDS_${PN} = "libqtphonon4"

FILES_${PN} += "\
    ${libdir}/kde4/*.so \
    ${datadir}"
FILES_${PN}-dbg += "${libdir}/kde4/.debug/"
