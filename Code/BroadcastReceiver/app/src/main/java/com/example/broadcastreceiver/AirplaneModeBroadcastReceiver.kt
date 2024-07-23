package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModeBroadcastReceiver:BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        var airplaneModeEnabled = p1?.getBooleanExtra("state",false) ?: return

        if(airplaneModeEnabled){
            Toast.makeText(p0, "Airplane mode enabled", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(p0, "Airplane mode disabled", Toast.LENGTH_SHORT).show()
        }
    }
}