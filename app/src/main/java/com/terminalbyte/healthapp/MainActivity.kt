package com.terminalbyte.healthapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.home_layout.*
import kotlinx.android.synthetic.main.login_or_signup.*
import java.io.File


class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null


    private var loginB: Button? = null
   // private var skipB: Button? = null
   // private var signUpB: Button? = null
    private var name: String? =null
    private var age: String? =null
    private val dbFileName="user_data"
    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_or_signup)//present screen
        setSupportActionBar(findViewById(R.id.action_bar))
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val spFile = File("""${applicationContext.applicationInfo.dataDir}/shared_prefs/$dbFileName.xml""")
        val sPreference = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        if(!spFile.exists()) {

            val edt: SharedPreferences.Editor = sPreference.edit()

            loginB = findViewById<Button>(R.id.login)//get the login button
            loginB?.setOnClickListener {
                //if the Login button is clicked
                //Intent of the login page
                name = get_name.text.toString()
                age = get_age.text.toString()
                edt.putString("name",name)
                edt.putString("age",age)
                edt.apply()
                val int = Intent(this, NavigationDrawerActivity::class.java)
                startActivity(int)//login page opens
            }
        }
        else{
            welcome_home.text=sPreference.getString("name"," ")//Check This...LOG THIS AND CHECK

            val int = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(int)

        }
        //Remove this after the fireBase setup...
        //skipB = findViewById<Button>(R.id.skipLogin)
       // skipB?.setOnClickListener {
         //   val hInt = Intent(this, NavigationDrawerActivity::class.java)
         //   startActivity(hInt)

        }
        //signUpB= findViewById<Button>(R.id.signUp)
        //signUpB?.setOnClickListener{
        //    val  sigUpPage = Intent(this, signUpActivity::class.java)
        //    startActivity(sigUpPage)
        }


        //val bgs=Intent(this, bgThreadWater::class.java)
       // startService(bgs)







