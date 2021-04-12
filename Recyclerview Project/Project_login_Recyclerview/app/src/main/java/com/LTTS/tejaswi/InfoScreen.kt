package com.felbsn.odev2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.READ_EXTERNAL_STORAGE

class InfoScreen : AppCompatActivity() {
    val PHONE_REQUEST_NUM = 454
    var mAdLabel: TextView? = null
    var mSoyadLabel: TextView? = null
    var mTcLabel: TextView? = null
    var mMailLabel: TextView? = null
    var mTelLabel: TextView? = null
    var callBtn: ImageButton? = null
    var mailBtn: ImageButton? = null
    var imgView: ImageView? = null
    var dersBtn: Button? = null
    var ableToCall = false
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_screen)
        setTitle("Information Screen")
        mAdLabel = findViewById(R.id.ad_info_view)
        mSoyadLabel = findViewById(R.id.soyad_info_view)
        mTcLabel = findViewById(R.id.tc_info_view)
        mMailLabel = findViewById(R.id.mail_info_view)
        mTelLabel = findViewById(R.id.tel_info_view)
        imgView = findViewById(R.id.imageView)
        callBtn = findViewById(R.id.callBtn)
        mailBtn = findViewById(R.id.mailBtn)
        dersBtn = findViewById(R.id.dersbtn_view)
        callBtn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                if (isPermissionGranted(CALL_PHONE, PHONE_REQUEST_NUM)) {
                    CallPhone()
                }
            }
        })
        mailBtn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + mMailLabel.getText().toString()))
                startActivity(intent)
            }
        })
        dersBtn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val intent = Intent(getApplicationContext(), LessonListener::class.java)
                startActivity(intent)
            }
        })
        fillForms()
    }

    fun CallPhone() {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mTelLabel.getText().toString()))
        startActivity(intent)
    }

    fun fillForms() {
        val it: Intent = getIntent()
        mAdLabel.setText(it.getStringExtra("ad"))
        mSoyadLabel.setText(it.getStringExtra("soyad"))
        mTcLabel.setText(it.getStringExtra("tc"))
        mMailLabel.setText(it.getStringExtra("mail"))
        mTelLabel.setText(it.getStringExtra("tel"))
        if (it.getStringExtra("imgUri") != null) {
            if (isPermissionGranted(READ_EXTERNAL_STORAGE, 44)) {
                val imgUri: Uri = Uri.parse(it.getStringExtra("imgUri"))
                try {
                    val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri)
                    imgView.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                // daha once izin vermis olması lazım , uri yi set edebilmesi icin...
            }
        } else {
            // image not set
        }
    }

    fun isPermissionGranted(PERM: String, REQ_CODE: Int): Boolean {
        return if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(PERM)
                    === PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(PERM), REQ_CODE)
                false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            true
        }
    }

    @Override
    fun onRequestPermissionsResult(requestCode: Int,
                                   permissions: Array<String?>?, grantResults: IntArray) {
        when (requestCode) {
            PHONE_REQUEST_NUM -> {
                if (grantResults.size > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Information", Toast.LENGTH_SHORT).show()
                    CallPhone()
                } else {
                    Toast.makeText(getApplicationContext(), "Information Screen", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}