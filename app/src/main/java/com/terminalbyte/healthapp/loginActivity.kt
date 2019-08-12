package com.terminalbyte.healthapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        setSupportActionBar(findViewById(R.id.action_bar))


    }
}