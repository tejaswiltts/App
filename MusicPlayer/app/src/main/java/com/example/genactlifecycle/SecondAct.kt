package com.example.genactlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonStart.setOnClickListener {

            var i = Intent(this,MyService::class.java)
            startService(i)
        }

        buttonStop.setOnClickListener {
            var i = Intent(this,MyService::class.java)
            stopService(i)
        }
    }
}