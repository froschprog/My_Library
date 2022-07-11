package com.froschprog.my_library.notifications

import android.app.Activity
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import androidx.core.app.NotificationCompat

/**
 * Builds and delivers the notification.
 *
 * @param messageTitle String
 * @param messageBody String
 * @param image Bitmap used as large image in the notification
 * @param smallIcon: Resource value of the small icon (in general app icon) of the notification
 * @param channelID: String
 * @param appCont: Context of the application
 * @param activity: Activity launched when clicking on notification
 */
fun NotificationManager.sendNotification(messageTitle: String, messageBody: String, image: Bitmap,
                                         smallIcon: Int, channelID: String, appCont: Context,
                                         activity: Class<Any>) {
    // Create the content intent for the notification to launch the MainActivity
    val contentIntent = Intent(appCont, activity)
    // create NotID
    val notID=messageTitle.hashCode()
    // create PendingIntent
    val contentPendingIntent = PendingIntent.getActivity(appCont, notID,
            contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    // get an instance of NotificationCompat.Builder
    // Build the notification
    val builder = NotificationCompat.Builder(appCont, channelID)
            //set title, text and Icon to builder
            .setSmallIcon(smallIcon)
            .setContentTitle(messageTitle)
            .setContentText(messageBody)
            // set content intent
            .setContentIntent(contentPendingIntent)
            .setAutoCancel(true)
            // add style to builder
            .setLargeIcon(image)
            // set priority
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    // call notify
    notify(notID, builder.build())
}