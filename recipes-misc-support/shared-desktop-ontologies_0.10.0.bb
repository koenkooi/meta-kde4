LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=f6b80fb30cbf01347ede9bfdd85b10fb"

DEPENDS = "docbook-utils-native"

inherit cmake

FILES_${PN} += "\
		/usr/share/ontology/* \
		/usr/share/cmake/* \
	       "

SRC_URI = "http://kent.dl.sourceforge.net/project/oscaf/shared-desktop-ontologies/0.10.0/shared-desktop-ontologies-0.10.0.tar.bz2"
SRC_URI[md5sum] = "bfb7b5acbb43e5e45466c87dbe9c45b7"
SRC_URI[sha256sum] = "b11901f016b54c8d00917cd167cf8585245ad266125880118f91e75ee52ac503"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

do_install_prepend() {
# Replace hardcoded /usr/ string
  sed -i "s|/usr/share|${STAGING_DATADIR}|" ${S}/build/SharedDesktopOntologiesConfig.cmake
}