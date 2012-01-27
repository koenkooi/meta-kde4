LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://kde4automoc.cpp;beginline=2;endline=23;md5=14e0a466a78db8537ab521a34551fc10"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/automoc;protocol=git;branch=master"
SRCREV = "a003654d36b9e409931d15af68091d1f366bd46e"

PV = "0.9.88+git${SRCPV}"

S = "${WORKDIR}/git" 

BBCLASSEXTEND = "native"