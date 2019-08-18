package com.terminalbyte.healthapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class HomeButton : Fragment() {

    private val dbFileName="user_data"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val preferences: SharedPreferences? = this.activity?.getSharedPreferences(dbFileName, Context.MODE_PRIVATE)
        val usrName=preferences?.getString("name","").toString()




        return LayoutInflater.from(container?.context).inflate(R.layout.home_layout, container, false)




    }

}




