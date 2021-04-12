package com.felbsn.odev2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Description : AppCompatActivity() {
    var ld: TextView? = null
    var ln: TextView? = null
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        setTitle("Description")
        val intent: Intent = getIntent()
        ld = findViewById(R.id.lessonDesc_s)
        ln = findViewById(R.id.lessonName_s)
        ln.setText(intent.getStringExtra("name"))
        ld.setText(intent.getStringExtra("desc"))
        findViewById(R.id.backBtn_s).setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                onBackPressed()
            }
        })
    }
}