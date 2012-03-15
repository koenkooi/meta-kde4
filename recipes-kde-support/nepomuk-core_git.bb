LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://server/main.cpp;beginline=1;endline=16;md5=445b0d89ea0a802153431b6d1f55bc6a"

#DEPENDS = "soprano"

inherit kde_cmake

SRC_URI = "git://anongit.kde.org/nepomuk-core.git;branch=master"
SRCREV = "8cc42cb460785220a376a017997bf5259382b8bb"

# nepomuk *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

EXTRA_OECMAKE =+ "\
		  -DNEPOMUK_INCLUDE_DIR=${STAGING_INCDIR}/KDE/Nepomuk/ \
		 "


PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

