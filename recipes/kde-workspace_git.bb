LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/kde-workspace;protocol=git;branch=master"
SRCREV = "2ad6abad3cbf0683d5d7841fd69e6bde7a42aafc"

PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

BBCLASSEXTEND = "native"