LICENSE = "GPLv3 LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://bitbucket.org/eigen/eigen/get/2.0.17.tar.bz2"
SRC_URI[md5sum] = "2dfd1e2765d82c306adbfcd6a0eb324b"
SRC_URI[sha256sum] = "7255e856ed367ce6e6e2d4153b0e4e753c8b8d36918bf440dd34ad56aff09960"

S = "${WORKDIR}/eigen-eigen-b23437e61a07"

inherit cmake
