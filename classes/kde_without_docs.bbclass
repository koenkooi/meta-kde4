### This class will remove the doc directory so it won't compain about:
### | make[2]: *** No rule to make target `/work/oe-core/tmp-eglibc/sysroots/overo/usr/share/apps/ksgmltools2/customization/kde-chunk.xsl', needed by `doc/dolphin/index.cache.bz2'.  Stop
###

do_configure_prepend() {
  cd ${S}
  if [ -d "./doc" ]; then
    rm -rf ./doc
  fi
}
