package com.github.androflo.ignorebatteryoptimisationchecker

import android.content.Context
import android.preference.PreferenceManager

object LibraryPreference {

    private const val KeySuccessfulChecks = "prefSuccessfulChecks"
    private const val KeyDisabled = "prefUserWontNeverShowDialog"


    fun getCheckNumber(context: Context): Int {

        return PreferenceManager.getDefaultSharedPreferences(context).getInt(KeySuccessfulChecks, 0)

    }

    fun setCheckNumber(context: Context, checks: Int) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(KeySuccessfulChecks, checks).apply()
    }

    fun isUserDisabledDialog(context: Context): Boolean {

        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(KeyDisabled, false)

    }

    fun setUserDisabledDialog(context: Context, disabled: Boolean) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(KeyDisabled, disabled).apply()
    }

}