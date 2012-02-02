LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=58ea69e00c0f1a17ba58451500255625"

require kde4.inc

SRC_URI = "git://anongit.kde.org/soprano.git;branch=master;tag=v2.6.0"
SRCREV = "2f5381c4c449f5c0b1390f7eaf00ef9216f8b5fa"

# soprano *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


do_compile() {
  cd ${S}/build/soprano && oe_runmake CC="${CC}" CXX="${CXX}"
}

do_install() {
  cd ${S}/build/soprano && oe_runmake install DESTDIR=${D}
  cd ${S}/build/includes && oe_runmake install DESTDIR=${D}
  cd ${S}/build/cmake && oe_runmake install DESTDIR=${D}
}

PV = "2.6+git${SRCPV}"

S = "${WORKDIR}/git"