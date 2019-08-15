package com.terminalbyte.healthapp

import android.app.IntentService
import android.content.Intent
import android.util.Log

class bgThreadWater : IntentService("bgThreadWater"){

       override fun onHandleIntent(p0: Intent?) {


            for (i in 1..5) {
                Thread.sleep(1000)
                Log.d("Thread", "THREAD:$i")
            }
        }
    }
