package com.felbsn.odev2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: View = findViewById(R.id.button)
        button.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val intent = Intent(getApplicationContext(), LoginScreen::class.java)
                startActivity(intent)
            }
        })
    }
}