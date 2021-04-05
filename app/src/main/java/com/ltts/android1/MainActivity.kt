package com.ltts.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button3.setOnClickListener {

            var un=textView1.text.toString()
            Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show()
            textView1.setText(un)


            var myIntent=Intent(this,MainActivity2::class.java)
            myIntent.putExtra("key",un)
            startActivity(myIntent)
        }
    }
}