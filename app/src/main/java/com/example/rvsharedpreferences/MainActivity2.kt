package com.example.rvsharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var tv:TextView
    private lateinit var btn3:Button

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        tv=findViewById(R.id.tv)
        btn3=findViewById(R.id.btnGet)
        val intent=intent
        val name =intent.getStringExtra("name")
        val lname =intent.getStringExtra("lname")
        tv.text="Your name is $name $lname"

        btn3.setOnClickListener {
           var name = sharedPreferences.getString("name", name).toString() // --> retrieves data from Shared Preferences
            var lname = sharedPreferences.getString("lname", lname).toString()
            tv.text="$name $lname"

        }
    }
}