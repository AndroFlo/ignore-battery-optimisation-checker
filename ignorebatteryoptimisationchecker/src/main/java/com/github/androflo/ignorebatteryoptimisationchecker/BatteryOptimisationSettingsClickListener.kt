package com.github.androflo.ignorebatteryoptimisationchecker

import android.content.Context
import android.content.DialogInterface

class BatteryOptimisationSettingsClickListener(private val context: Context) : DialogInterface.OnClickListener {

    override fun onClick(dialog: DialogInterface, which: Int) {
        UtilsLibrary.startPowerSettings(context)
    }
}
