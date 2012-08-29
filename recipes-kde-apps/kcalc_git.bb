LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4"

inherit kde_cmake kde_rdepends kde_without_docs perlnative

SRC_URI = "git://anongit.kde.org/kcalc;protocol=git;branch=master \
    file://Make-docs-optional.patch"

## Tag 4.8.0
SRCREV = "c21fff5322c266d025e1f600044b2423310f1f5f"

PV = "4.8.0+git${SRCPV}"

PR = "r1"

S = "${WORKDIR}/git"

FILES_${PN} += "\
    ${libdir}/libkdeinit4_kcalc.so \
    \
    ${datadir}/* \
    "

# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
