QT_GLFLAGS_omap3 = "-egl"
DEPENDS_append_omap3 = " libgles-omap3"

# Needed by kdelibs
QT_DISTRO_FLAGS = "-accessibility -sm"

PRINC := "${@int(PRINC) + 1}"