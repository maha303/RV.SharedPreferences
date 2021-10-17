package com.example.rvsharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var ed1:EditText
    private lateinit var ed2:EditText
    private lateinit var btn1:Button
    private lateinit var btn2:Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        ed1=findViewById(R.id.edname)
        ed2=findViewById(R.id.edlname)

        btn1=findViewById(R.id.btn1)
        btn1.setOnClickListener{
            val name=ed1.text.toString()
            val lname=ed2.text.toString()
            val int = Intent(this,MainActivity2::class.java)
            int.putExtra("name",name)
            int.putExtra("lname",lname)
            startActivity(int)
        }
        btn2=findViewById(R.id.btn2)
        btn2.setOnClickListener {
            val name=ed1.text.toString()
            val lname=ed2.text.toString()
            with(sharedPreferences.edit()) {
                putString("name", name)
                putString("lname",lname)
                apply()

            }
            Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
        }

    }
}