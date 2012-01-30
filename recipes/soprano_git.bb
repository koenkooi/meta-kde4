LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

inherit qt4x11 cmake
require kde4.inc

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master;tag=v2.6.0"
#SRCREV = "2f5381c4c449f5c0b1390f7eaf00ef9216f8b5fa"

PV = "2.6+git${SRCPV}"

S = "${WORKDIR}/git"