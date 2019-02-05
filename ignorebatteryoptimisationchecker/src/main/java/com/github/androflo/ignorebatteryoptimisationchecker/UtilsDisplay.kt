package com.github.androflo.ignorebatteryoptimisationchecker

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.media.RingtoneManager
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import com.google.android.material.snackbar.Snackbar

object UtilsDisplay {

    fun showBatteryOptimisationNeedDialog(context: Context, title: String, content: String, btnNegative: String, btnPositive: String, btnNeutral: String, updateClickListener: DialogInterface.OnClickListener?, dismissClickListener: DialogInterface.OnClickListener?, disableClickListener: DialogInterface.OnClickListener?): AlertDialog {
        return AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton(btnPositive, updateClickListener)
                .setNegativeButton(btnNegative, dismissClickListener)
                .setNeutralButton(btnNeutral, disableClickListener).create()
    }

    fun showBatteryOptimisationNeedSnackbar(context: Context, content: String, indefinite: Boolean): Snackbar {
        val activity = context as Activity
        val snackbarTime = if (indefinite) Snackbar.LENGTH_INDEFINITE else Snackbar.LENGTH_LONG

        /*if (indefinite) {
            snackbarTime = Snackbar.LENGTH_INDEFINITE;
        } else {
            snackbarTime = Snackbar.LENGTH_LONG;
        }*/

        val snackbar = Snackbar.make(activity.findViewById(android.R.id.content), content, snackbarTime)
        snackbar.setAction(context.getResources().getString(R.string.button_settings)) { UtilsLibrary.startPowerSettings(context) }
        return snackbar
    }

    fun showUpdateAvailableNotification(context: Context, title: String, content: String, smallIconResourceId: Int) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        initNotificationChannel(context, notificationManager)

        val contentIntent = PendingIntent.getActivity(context, 0, context.packageManager.getLaunchIntentForPackage(context.packageName), PendingIntent.FLAG_CANCEL_CURRENT)
        val pendingIntentUpdate = PendingIntent.getActivity(context, 0, UtilsLibrary.getPowerSettingsIntent(), PendingIntent.FLAG_CANCEL_CURRENT)

        val builder = getBaseNotification(context, contentIntent, title, content, smallIconResourceId)
                .addAction(R.drawable.ic_settings_white_24dp, context.resources.getString(R.string.button_settings), pendingIntentUpdate)

        notificationManager.notify(0, builder.build())
    }

    fun showUpdateNotAvailableNotification(context: Context, title: String, content: String, smallIconResourceId: Int) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        initNotificationChannel(context, notificationManager)

        val contentIntent = PendingIntent.getActivity(context, 0, context.packageManager.getLaunchIntentForPackage(context.packageName), PendingIntent.FLAG_CANCEL_CURRENT)

        val builder = getBaseNotification(context, contentIntent, title, content, smallIconResourceId)
                .setAutoCancel(true)

        notificationManager.notify(0, builder.build())
    }

    private fun getBaseNotification(context: Context, contentIntent: PendingIntent, title: String, content: String, smallIconResourceId: Int): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, context.getString(R.string.ignore_battery_otpimisation_checker_channel))
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(NotificationCompat.BigTextStyle().bigText(content))
                .setSmallIcon(smallIconResourceId)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)

    }

    private fun initNotificationChannel(context: Context, notificationManager: NotificationManager) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                    context.getString(R.string.ignore_battery_otpimisation_checker_channel),
                    context.getString(R.string.ignore_battery_otpimisation_checker_channel_name),
                    NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(mChannel)
        }
    }
}