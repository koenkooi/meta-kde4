### Purpose: This script will patch exported cmake files that point to an absolute path under /usr/lib or the like
### Usage: Add the files to patch to the KDE_EXPORT_PATCH variable.
### Don't inherit this from outside of meta-kde

do_install_prepend() {
    echo "kde-exports.bbclass do_install_prepend() started"
    tmp_files_array=$(echo ${KDE_EXPORT_FILES} | tr " " "\n")
    for tmp_destfile in ${tmp_files_array}
    do
      echo "# Patching /usr/ to \${STAGING_DIR_TARGET}\${prefix} for  ${tmp_destfile}"
      sed -i 's|"/usr/|"${STAGING_DIR_TARGET}${prefix}/|'  ${tmp_destfile}
    done
}

python __anonymous() {
    if not bb.data.inherits_class('native', d) and not bb.data.inherits_class('cross', d):
        kdeexports_check = d.getVar('KDE_EXPORT_FILES')
        if not kdeexports_check:
            bb_filename = d.getVar('FILE')
            raise bb.build.FuncFailed, "\n\n\nERROR: %s inherits kde_exports but doesn't set KDE_EXPORT_FILES" % bb_filename
}

