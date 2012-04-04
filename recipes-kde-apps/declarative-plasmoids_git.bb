LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "kde-workspace qimageblitz"

inherit kde_cmake kde_rdepends

SRC_URI = "git://anongit.kde.org/declarative-plasmoids;protocol=git;branch=master"
SRCREV = "f145d84073271e7a5fd0a7a2e573a85c9a3d509b"

PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/*"
