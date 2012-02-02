LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

#DEPENDS = "soprano"

require kde4.inc

SRC_URI = "git://anongit.kde.org/nepomuk-core.git;branch=master"
SRCREV = "8cc42cb460785220a376a017997bf5259382b8bb"

# nepomuk *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"