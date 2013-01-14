# Needed by kdelibs4-native
DEPENDS += "openssl-native"
PRINC := "${@int(PRINC) + 1}"

EXTRA_OECONF += "-no-pch -no-sm -openssl"

TOBUILD += "src/phonon"

PRINC := "${@int(PRINC) + 1}"
