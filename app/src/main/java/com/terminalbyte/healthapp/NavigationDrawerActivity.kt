package com.terminalbyte.healthapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var pLayout: String? =null
    private val dbFileName="user_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        //val toolbar: Toolbar = findViewById(R.id.toolbar)
       // setSupportActionBar(toolbar)

        val pref:SharedPreferences = getSharedPreferences(dbFileName, Context.MODE_PRIVATE)

        val name:String=pref.getString("name",null).toString()
        Log.d("SPSTRING",name)

        //this.user_name.text = "Hello"


        loadHome(home = HomeButton())

        pLayout="home"


        //val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        //val toggle = ActionBarDrawerToggle(
        //    this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
       // )
      //  drawerLayout.addDrawerListener(toggle)
       // toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            Toast.makeText(applicationContext, "Operation Not Allowed", Toast.LENGTH_LONG).show()
        }
    }

   // override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
   //     menuInflater.inflate(R.menu.navigation_drawer, menu)
   //     return true
   // }

    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  return when (item.itemId) {
        //    R.id.action_settings -> true
         //   else -> super.onOptionsItemSelected(item)
       // }
  //  }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                if(pLayout!="home")
                loadHome(home=HomeButton())
            }
            R.id.set_alarm -> {
                if(pLayout!="alarm")
                setAlarm(alarmset = setAlarmButton())


            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadHome(home:HomeButton) {


        val hm = supportFragmentManager.beginTransaction()
        hm.replace(R.id.frameLayout, home)
        pLayout="home"

        hm.commit()
    }
    private fun setAlarm(alarmset: setAlarmButton ) {
        val hm = supportFragmentManager.beginTransaction()
        hm.replace(R.id.frameLayout, alarmset)
        pLayout="alarm"
        hm.commit()}

}
