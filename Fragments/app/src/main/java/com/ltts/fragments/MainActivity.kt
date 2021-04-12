package com.ltts.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        blue.setOnClickListener {
            var blueFragment= fragment()
            var manage=supportFragmentManager
            var transact=manage.beginTransaction()
            transact.replace(R.id.fragment,fragment)
            transact.commit()
        }
    }
}