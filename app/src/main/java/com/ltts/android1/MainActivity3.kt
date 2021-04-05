package com.ltts.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button4.setOnClickListener {
            var myIntent= Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            Toast.makeText(this,"homepage", Toast.LENGTH_LONG).show()
        }
    }
}