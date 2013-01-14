DESCRIPTION = "Qt-only wrapper for NetworkManager API."
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/Licensing_Policy;md5=e8b46f5b1b4bd20c87d3f6d2ba120ffc"
DEPENDS = "libmm-qt networkmanager"
# latest / master HEAD
SRCREV = "6723766fe473b0331deb5285831609e2a268c44c"
PV = "+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/libnm-qt.git;branch=master \
    http://techbase.kde.org/Policies/Licensing_Policy"
# for license file
SRC_URI[md5sum] = "e8b46f5b1b4bd20c87d3f6d2ba120ffc"
SRC_URI[sha256sum] = "92d3083c97b3fde787556a28f0b3f3f1779d02fb30b429ffa37a56e1df6ab867"

S = "${WORKDIR}/git"

inherit kde_cmake

RDEPENDS_${PN} = "libmm-qt networkmanager"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
