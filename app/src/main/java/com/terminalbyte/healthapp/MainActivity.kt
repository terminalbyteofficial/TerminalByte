package com.terminalbyte.healthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var loginB: Button? = null
    private var skipB: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_or_signup)//present screen
        setSupportActionBar(findViewById(R.id.action_bar))

        loginB= findViewById<Button>(R.id.loginButton)//get the login button
        loginB?.setOnClickListener{//if the Login button is clicked
            //Intent of the login page
            val int= Intent(this, loginActivity::class.java)
            startActivity(int)//login page opens
        }
        //Remove this after the fireBase setup...
        skipB = findViewById<Button>(R.id.skipLogin)
        skipB?.setOnClickListener {
            val hInt = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(hInt)
        }
        val bgs=Intent(this, bgThreadWater::class.java)
        startService(bgs)





    }
}
