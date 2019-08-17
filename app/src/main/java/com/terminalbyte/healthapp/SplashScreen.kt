package com.terminalbyte.healthapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        for(i in 1..5)
        {
            Thread.sleep(1000)
        }

        val intent= Intent(this,NavigationDrawerActivity::class.java)
        startActivity(intent)
    }
}
