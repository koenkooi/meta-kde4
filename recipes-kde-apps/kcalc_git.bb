LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"
DEPENDS = "kdelibs4"
## Tag 4.10.0
SRCREV = "d38f867fa890dfa2274b87bdb787f3c47ef94fc4"
PV = "4.10.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/kcalc;protocol=git;branch=master \
    file://Make-docs-optional.patch"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends kde_without_docs perlnative

FILES_${PN} += "\
    ${libdir}/libkdeinit4_kcalc.so \
    \
    ${datadir}/* \
    "
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
