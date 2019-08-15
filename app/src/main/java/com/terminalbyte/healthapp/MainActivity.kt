package com.terminalbyte.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.terminalbyte.healthapp.R.id.loginButton
import kotlinx.android.synthetic.main.login_or_signup.*

class MainActivity : AppCompatActivity() {

    private var loginB: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//present screen
        setContentView(R.layout.login_or_signup)
        setSupportActionBar(findViewById(R.id.action_bar))
        loginB= findViewById(R.id.loginButton) as Button//get the login button
        loginB?.setOnClickListener {

            //Intent of the login page
            val int= Intent(this, loginActivity::class.java)
            startActivity(int)//login page opens
        }}


    }

