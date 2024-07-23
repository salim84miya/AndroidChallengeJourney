package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyService:Service() {

    val TAG = "MyService"

    init {
        Log.d(TAG,"Service running...")
    }

    override fun onBind(p0: Intent?): IBinder?= null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val dataString = intent?.getStringExtra("EXTRA_DATA")

        dataString?.let{
            Log.d(TAG,dataString)
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"service is being killed...")
    }
}