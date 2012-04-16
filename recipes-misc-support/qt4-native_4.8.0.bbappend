# Needed by kdelibs4-native
DEPENDS += "openssl-native"

EXTRA_OECONF += "-no-pch -no-sm -openssl"

TOBUILD += "src/phonon"
