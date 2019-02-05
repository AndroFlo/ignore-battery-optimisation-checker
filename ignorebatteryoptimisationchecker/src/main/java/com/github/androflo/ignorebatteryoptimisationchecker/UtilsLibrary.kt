package com.github.androflo.ignorebatteryoptimisationchecker

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.annotation.RequiresApi

object UtilsLibrary {

    @RequiresApi
    fun isAppWhiteListed(context: Context): Boolean {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val oPowerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            return oPowerManager.isIgnoringBatteryOptimizations(context.packageName)

        }
        return true

    }

    fun startPowerSettings(context: Context) {

        context.startActivity(getPowerSettingsIntent())

    }

    fun getPowerSettingsIntent(): Intent? {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val intent = Intent()
            intent.action = Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS
            return intent
        }
        return null
    }

    fun isAbleToShow(successfulChecks: Int?, showEvery: Int?): Boolean {
        return successfulChecks!! % showEvery!! == 0
    }
}