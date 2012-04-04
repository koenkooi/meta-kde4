LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7dbc59dc445b2261c4fb2f9466e3446a"

DEPENDS = "automoc4-native polkit"
RDEPENDS_${PN} = "libqtcore4 polkit"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/polkit-qt-1.git;branch=master"

## Tag v0.103.0
SRCREV = "26045cb6da3efb1eba8612ef47ffa63da64ae9a0"

EXTRA_OECMAKE =+ "-DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  -DUSE_COMMON_CMAKE_PACKAGE_CONFIG_DIR=FALSE"

FILES_${PN}-dev = "${libdir}/PolkitQt-1/cmake"

PV = "v0.103.0+git${SRCPV}"

S = "${WORKDIR}/git"

