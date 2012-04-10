LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=f6b80fb30cbf01347ede9bfdd85b10fb"

DEPENDS = "docbook-utils-native"

inherit cmake

FILES_${PN} += "\
		/usr/share/ontology/* \
		/usr/share/cmake/* \
	       "

SRC_URI = "http://kent.dl.sourceforge.net/project/oscaf/shared-desktop-ontologies/0.9/shared-desktop-ontologies-0.9.0.tar.bz2"

SRC_URI[md5sum] = "8cd0950dc66eb5fbe560ac7fdb416e04"
SRC_URI[sha256sum] = "6efaf4caed8b5467390dc6ae62c678b28fd753df524c257f0a938c2a7b6ac526"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

do_install_prepend() {
# Replace hardcoded /usr/ string
  sed -i "s|/usr/share|${STAGING_DATADIR}|" ${S}/build/SharedDesktopOntologiesConfig.cmake
}