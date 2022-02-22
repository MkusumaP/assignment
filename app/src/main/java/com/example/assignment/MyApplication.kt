package com.example.assignment

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Screen Change"
            val descriptionText = "Fragment Changed"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channelId = "1"
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val name2 = "Fragment Change"
            val descriptionText2 = "Fragment data displayed"
            val importance2 = NotificationManager.IMPORTANCE_LOW
            val channelId2 = "2"
            val channel2 = NotificationChannel(channelId2, name2, importance2).apply {
                description = descriptionText2
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }
    }
}