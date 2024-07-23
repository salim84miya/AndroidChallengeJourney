package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService:IntentService("MyIntentService") {

    //primary constructor for initializing intent service instance
    init {
        instance = this
    }

    companion object{

        //variable for checking if service running or stopped
        var isRunning = false

        //instance of intent service for stopping
        lateinit var instance:MyIntentService


        fun stopService(){
            isRunning = false
            Log.d("MyIntentService","Service stopped......")

            //stopping the service/service intent instance
            instance.stopSelf()
        }

    }


    override fun onHandleIntent(p0: Intent?) {

        try{
            isRunning= true
            while(isRunning){
                Log.d("MyIntentService","Service running....")

                //this sleep function can throw interrupt exception so surround with try and catch block
                Thread.sleep(1000)
            }
        }catch (e:InterruptedException){

            //the thread which is sleeping or is in wait state is break out of sleep
            Thread.currentThread().interrupt()
        }


    }





}