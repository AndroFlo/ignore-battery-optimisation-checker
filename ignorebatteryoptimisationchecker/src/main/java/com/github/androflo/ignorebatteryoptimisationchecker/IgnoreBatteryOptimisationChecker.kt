package com.github.androflo.ignorebatteryoptimisationchecker

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.github.androflo.ignorebatteryoptimisationchecker.enums.Display
import com.github.androflo.ignorebatteryoptimisationchecker.interfaces.IIgnoreBatteryOptimisationChecker


/**
 * @author Audigué Florian on 04/02/2019.
 * @company Sanilea SAS
 * @email florian.audigue@sanilea.fr
 *      /\_/\
 *      ='_' )
 *    (, (") (")
 */
class IgnoreBatteryOptimisationChecker(private val context: Context) : IIgnoreBatteryOptimisationChecker {


    private var showEvery = 1

    private var title = context.getString(R.string.dialog_title)
    private var content = context.getString(R.string.dialog_content)
    private var btnSettings = context.getString(R.string.button_settings)
    private var btnDismiss = context.getString(R.string.button_close)
    private var btnDisable = context.getString(R.string.button_disable)
    private var display: Display = Display.DIALOG
    private var isDialogCancelable = true
    private var iconResId = R.drawable.ic_settings_white_24dp

    private var btnUpdateClickListener: DialogInterface.OnClickListener? = null
    private var btnDismissClickListener: DialogInterface.OnClickListener? = null
    private var btnDisableClickListener: DialogInterface.OnClickListener? = null

    private var alertDialog: AlertDialog? = null
    private var snackbar: Snackbar? = null


    override fun setDisplay(display: Display): IgnoreBatteryOptimisationChecker {
        this.display = display
        return this
    }

    override fun showEvery(times: Int): IgnoreBatteryOptimisationChecker {
        this.showEvery = times
        return this
    }

    override fun setTitleOnAppNotWhiteListed(textResource: Int): IgnoreBatteryOptimisationChecker {
        this.title = context.getString(textResource)
        return this
    }

    override fun setContentOnAppNotWhiteListed(textResource: Int): IgnoreBatteryOptimisationChecker {
        this.content = context.getString(textResource)
        return this
    }


    override fun setButtonSettings(textResource: Int): IgnoreBatteryOptimisationChecker {
        this.btnSettings = context.getString(textResource)
        return this
    }

    override fun setButtonDismiss(textResource: Int): IgnoreBatteryOptimisationChecker {
        this.btnDismiss = context.getString(textResource)
        return this
    }

    override fun setButtonDoNotShowAgain(textResource: Int): IgnoreBatteryOptimisationChecker {
        this.btnDisable = context.getString(textResource)
        return this
    }

    override fun setButtonUpdateClickListener(clickListener: DialogInterface.OnClickListener): IgnoreBatteryOptimisationChecker {
        this.btnUpdateClickListener = clickListener
        return this
    }

    override fun setButtonDismissClickListener(clickListener: DialogInterface.OnClickListener): IgnoreBatteryOptimisationChecker {
        this.btnDismissClickListener = clickListener
        return this
    }

    override fun setButtonDoNotShowAgainClickListener(clickListener: DialogInterface.OnClickListener): IgnoreBatteryOptimisationChecker {
        this.btnDisableClickListener = clickListener
        return this
    }

    override fun setIcon(iconRes: Int): IgnoreBatteryOptimisationChecker {
        this.iconResId = iconRes
        return this
    }

    override fun setCancelable(isCancelable: Boolean): IgnoreBatteryOptimisationChecker {
        this.isDialogCancelable = isCancelable
        return this
    }

    override fun check() {

        val checksNumber = LibraryPreference.getCheckNumber(context)
        val isUserDisabledDialog = LibraryPreference.isUserDisabledDialog(context)

        if (UtilsLibrary.isAbleToShow(checksNumber, showEvery) && !UtilsLibrary.isAppWhiteListed(context) && !isUserDisabledDialog) {

            when (display) {
                Display.DIALOG -> {
                    val updateClickListener = if (btnUpdateClickListener == null) BatteryOptimisationSettingsClickListener(context) else btnUpdateClickListener
                    val disableClickListener = if (btnDisableClickListener == null) DisableClickListener(context) else btnDisableClickListener

                    alertDialog = UtilsDisplay.showBatteryOptimisationNeedDialog(context, title, content, btnDismiss, btnSettings, btnDisable, updateClickListener, btnDismissClickListener, disableClickListener)
                    alertDialog?.setCancelable(isDialogCancelable)
                    alertDialog?.show()
                }
                Display.SNACKBAR -> {
                    snackbar = UtilsDisplay.showBatteryOptimisationNeedSnackbar(context, content, true)
                    snackbar?.show()
                }
                Display.NOTIFICATION -> UtilsDisplay.showUpdateAvailableNotification(context, title, content, iconResId)
            }

        }
        LibraryPreference.setCheckNumber(context, checksNumber + 1)
    }


    override fun dismiss() {
        if (alertDialog != null && alertDialog?.isShowing == true) {
            alertDialog?.dismiss()
        }
        if (snackbar != null && snackbar?.isShown == true) {
            snackbar?.dismiss()
        }
    }
}