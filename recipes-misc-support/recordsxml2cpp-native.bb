DESCRIPTION = "A native compiled tool needed by the Calligra software suite"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://recordsxml2cpp.cpp;beginline=1;endline=17;md5=8b4bcbbbafbff7c60f6e75e8f3f4f059"

SRC_URI = "file://recordsxml2cpp.cpp \
           file://recordsxml2cpp.pro"

S = "${WORKDIR}"

inherit qt4x11 native

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/recordsxml2cpp ${D}${bindir}
}
