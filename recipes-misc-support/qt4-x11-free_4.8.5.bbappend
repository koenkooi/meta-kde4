PRINC := "${@int(PRINC) + 4}"

#This will add reduced visibility to some exports on Qt, otherwise KDE plugins will fail
QT_CONFIG_FLAGS_append = " --reduce-exports"

# Needed by kdelibs
QT_DISTRO_FLAGS = "-accessibility -sm"
