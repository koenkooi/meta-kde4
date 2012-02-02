LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://../COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

inherit native

SRC_URI = "file://KDELibs4LibraryTargets.cmake \
	   file://KDELibs4ToolsTargets.cmake \
	   file://COPYING \
	  "

# This files are required but not contained in the kdelibs4 cmake packages, so they were copied over.
do_install() {
  install -d ${D}${datadir}/apps/cmake/modules
  install -m 0644 ${WORKDIR}/KDELibs4LibraryTargets.cmake ${D}${datadir}/apps/cmake/modules
  install -m 0644 ${WORKDIR}/KDELibs4ToolsTargets.cmake ${D}${datadir}/apps/cmake/modules
}
