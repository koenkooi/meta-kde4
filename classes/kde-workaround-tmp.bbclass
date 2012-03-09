### Temporary WORKAROUND until KDE has cross compile support
### During the installation of kdelibs4 cmake files with hard coded installation paths will be created.
### These files result in other programs trying to install to the same pathts, this 

do_kde_workaround() {
cd ${D}
tmp_relative_staging_dir_target=`echo "${STAGING_DIR_TARGET}" | sed 's|^/||'`
if [ -d "./${tmp_relative_staging_dir_target}" ]; then
# This script uses tar as it will preserve metadate like timestamps
  cd ${D}/${tmp_relative_staging_dir_target} && (tar cf - . |(cd ${D}; tar xvf -))
  cd ${D} && rm -rf ./${tmp_relative_staging_dir_target}/*
  rmdir -p ${tmp_relative_staging_dir_target}
else
  echo "Nothing to be done for ${PN}"
fi
}
addtask kde_workaround after do_install before do_package
