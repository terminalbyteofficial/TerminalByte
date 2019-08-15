package com.terminalbyte.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.terminalbyte.healthapp.R.id.loginButton
import kotlinx.android.synthetic.main.login_or_signup.*

class MainActivity : AppCompatActivity() {

    private var loginB: Button? = null
    private var skipB: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_or_signup)//present screen
        setSupportActionBar(findViewById(R.id.action_bar))

        loginB= findViewById(R.id.loginButton) as Button//get the login button
        loginB?.setOnClickListener{//if the Login button is clicked
            //Intent of the login page
            val int= Intent(this, loginActivity::class.java)
            startActivity(int)//login page opens
        }
        //Remove this after the fireBase setup...
        skipB = findViewById(R.id.skipButton) as Button
        skipB?.setOnClickListener {
            val hInt = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(hInt)
        }
        val bgs=Intent(this, bgThreadWater::class.java)
        startService(bgs)





    }
}
