package com.example.genactlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(editTextTextPersonName)

        Log.i("mytag","Activity Created")

        button.setOnClickListener {

            var i  = Intent(this,SecondAct::class.java)
            startActivity(i)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.mymenu,menu)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        var id = item.itemId

        if(id==R.id.idmyact){
            var i  = Intent(this,SecondAct::class.java)
            startActivity(i)
        }

        if(id==R.id.idtoast){
            Toast.makeText(this,"Toast selected",Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.itemId

        if(id==R.id.idmyact){
            var i  = Intent(this,SecondAct::class.java)
            startActivity(i)
        }

        if(id==R.id.idtoast){
            Toast.makeText(this,"Toast selected",Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
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