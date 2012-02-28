
### Purpose: This script will patch exported cmake files that point to an absolute path under /usr/lib or the like
### Usage: Add the files to patch to the KDE_EXPORT_PATCH variable.
### Don't inherit this from outside of meta-kde

do_install_prepend() {
    echo "kde-exports.bbclass do_install_prepend() started"
    tmp_files_array=$(echo ${KDE_EXPORT_FILES} | tr " " "\n")

    for tmp_destfile in ${tmp_files_array}
    do
      echo "Patching /usr/ to ${STAGING_DIR_TARGET}${prefix} for  ${tmp_destfile}"
      cat ${tmp_destfile} | sed 's|"/usr/|"${STAGING_DIR_TARGET}${prefix}/|'
      cat ${WORKDIR}/tmp_swapfile > ${tmp_destfile}
      rm ${WORKDIR}/tmp_swapfile
    done
}

def kde_exports_after_parse(d):
	def systemd_check_vars():
		if d.getVar('BB_WORKERCONTEXT', True) is not None:
			return
		kde_exports = d.getVar('KDE_EXPORT_FILES', 1) or ""
		if kde_exports == "":
			raise bb.build.FuncFailed, "\n\n%s inherits kde-exports.bbclass but doesn't set KDE_EXPORT_FILES" % bb_filename

python __anonymous() {
    kde_exports_after_parse(d)
}