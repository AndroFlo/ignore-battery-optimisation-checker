package com.github.androflo.ignorebatteryoptimisationchecker.interfaces;

import android.content.DialogInterface;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.github.androflo.ignorebatteryoptimisationchecker.IgnoreBatteryOptimisationChecker;
import com.github.androflo.ignorebatteryoptimisationchecker.enums.Display;

public interface IIgnoreBatteryOptimisationChecker {
    /**
     * Set the type of message used to notify the user when a new update has been found. Default: DIALOG.
     *
     * @param display how the update will be shown
     * @return this
     */
    IgnoreBatteryOptimisationChecker setDisplay(Display display);

    /**
     * Set the times the app ascertains that a new update is available and display a dialog, Snackbar or notification. It makes the updates less invasive. Default: 1.
     *
     * @param times every X times
     * @return this
     */
    IgnoreBatteryOptimisationChecker showEvery(Integer times);

    /**
     * Set a custom title for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    IgnoreBatteryOptimisationChecker setTitleOnAppNotWhiteListed(@StringRes int textResource);

    /**
     * Set a custom description for the dialog when an update is available.
     *
     * @param textResource resource from the strings xml file for the dialog
     * @return this
     */
    IgnoreBatteryOptimisationChecker setContentOnAppNotWhiteListed(@StringRes int textResource);
    

    /**
     * Set a custom "Update" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the update button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonSettings(@StringRes int textResource);

    /**
     * Set a custom "Dismiss" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the dismiss button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonDismiss(@StringRes int textResource);

    /**
     * Set a custom "Don't show again" button text when a new update is available.
     *
     * @param textResource resource from the strings xml file for the disable button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonDoNotShowAgain(@StringRes int textResource);

    /**
     * Sets a custom click listener for the "Update" button when a new update is available.
     * In order to maintain the default functionality, extend {@link com.github.androflo.ignorebatteryoptimisationchecker.BatteryOptimisationSettingsClickListener}
     *
     * @param clickListener for update button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonUpdateClickListener(DialogInterface.OnClickListener clickListener);

    /**
     * Sets a custom click listener for the "Dismiss" button when a new update is available.
     *
     * @param clickListener for dismiss button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonDismissClickListener(DialogInterface.OnClickListener clickListener);

    /**
     * Sets a custom click listener for the "Don't show again" button when a new update is available. <br/>
     * In order to maintain the default functionality, extend {@link com.github.androflo.ignorebatteryoptimisationchecker.DisableClickListener}
     *
     * @param clickListener for disable button
     * @return this
     */
    IgnoreBatteryOptimisationChecker setButtonDoNotShowAgainClickListener(DialogInterface.OnClickListener clickListener);

    /**
     * Sets the resource identifier for the small notification icon
     *
     * @param iconRes The id of the drawable item
     * @return this
     */
    IgnoreBatteryOptimisationChecker setIcon(@DrawableRes int iconRes);

    /**
     * Make update dialog non-cancelable, and
     * force user to make update
     *
     * @param isCancelable true to force user to make update, false otherwise
     * @return this
     */
    IgnoreBatteryOptimisationChecker setCancelable(Boolean isCancelable);

    /**
     * Execute IgnoreBatteryOptimisationChecker in background.
     */
    void check();

    /**
     * Dismisses the alert dialog or the snackbar.
     */
    void dismiss();

}
