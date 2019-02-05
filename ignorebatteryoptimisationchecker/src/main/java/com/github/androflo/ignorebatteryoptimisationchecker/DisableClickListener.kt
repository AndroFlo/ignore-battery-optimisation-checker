package com.github.androflo.ignorebatteryoptimisationchecker

import android.content.Context
import android.content.DialogInterface

class DisableClickListener(private val context: Context) : DialogInterface.OnClickListener {


    override fun onClick(dialog: DialogInterface, which: Int) {
        LibraryPreference.setUserDisabledDialog(context, true)
    }
}
