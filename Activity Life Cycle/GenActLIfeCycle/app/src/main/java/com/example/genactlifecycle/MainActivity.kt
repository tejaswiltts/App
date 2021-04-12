package com.example.genactlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("mytag","Activity Created")

        button.setOnClickListener {

            var i  = Intent(this,SecondAct::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","Activity started")

    }

    override fun onResume() {
        super.onResume()

        Log.i("mytag","Activity Resumed")

    }

    override fun onPause() {
        super.onPause()

        Log.i("mytag","Activity Paused")

    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","Activity Stopped")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("mytag","Activity Destroyed")

    }

    override fun onRestart() {
        super.onRestart()

        Log.i("mytag","Activity REstarted")

    }
}