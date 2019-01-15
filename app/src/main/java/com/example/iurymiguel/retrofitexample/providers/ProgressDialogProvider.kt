package com.example.iurymiguel.retrofitexample.providers

import android.app.ProgressDialog
import android.content.Context
import com.example.iurymiguel.retrofitexample.R

class ProgressDialogProvider() {

    private lateinit var mProgressDialog: ProgressDialog

    fun show(context: Context?) {
        mProgressDialog = ProgressDialog.show(context, "", context!!.getString(R.string.loading))
        mProgressDialog.setCancelable(false)
    }

    fun dismiss() {
        mProgressDialog.dismiss()
    }

}