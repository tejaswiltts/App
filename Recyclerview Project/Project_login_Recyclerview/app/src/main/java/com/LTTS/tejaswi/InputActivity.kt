package com.felbsn.odev2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.IOException

class InputActivity : AppCompatActivity() {
    val OPEN_IMG_CODE = 245
    val READ_EXTERNAL_REQUEST = 44
    var mTcView: EditText? = null
    var mAdView: EditText? = null
    var mSoyadView: EditText? = null
    var mMailView: EditText? = null
    var mTelView: EditText? = null
    var mImgBtn: ImageButton? = null
    var mTemizle: Button? = null
    var mKaydet: Button? = null
    var mEkleBtn: Button? = null
    var imageUri: Uri? = null
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        setTitle("Input Activity")
        mTcView = findViewById(R.id.tc_view)
        mAdView = findViewById(R.id.ad_view)
        mSoyadView = findViewById(R.id.soyad_view)
        mMailView = findViewById(R.id.mail_view)
        mTelView = findViewById(R.id.tel_view)
        mImgBtn = findViewById(R.id.imgBtn_view)
        mTemizle = findViewById(R.id.sTemizle_view)
        mKaydet = findViewById(R.id.sKaydet_view)
        mEkleBtn = findViewById(R.id.ppEkleView)
        mImgBtn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                if (isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_REQUEST)) {
                    val intent = Intent(Intent.ACTION_GET_CONTENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.setType("image/*")
                    startActivityForResult(intent, OPEN_IMG_CODE)
                }
            }
        })
        mEkleBtn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                if (isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_REQUEST)) {
                    val intent = Intent(Intent.ACTION_GET_CONTENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.setType("image/*")
                    startActivityForResult(intent, OPEN_IMG_CODE)
                }
            }
        })
        mTemizle.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                mAdView.getText().clear()
                mTcView.getText().clear()
                mSoyadView.getText().clear()
                mMailView.getText().clear()
                mTelView.getText().clear()
            }
        })
        mKaydet.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val nextPhaze = Intent(getApplicationContext(), InfoScreen::class.java)
                nextPhaze.putExtra("ad", mAdView.getText().toString())
                nextPhaze.putExtra("tc", mTcView.getText().toString())
                nextPhaze.putExtra("soyad", mSoyadView.getText().toString())
                nextPhaze.putExtra("mail", mMailView.getText().toString())
                nextPhaze.putExtra("tel", mTelView.getText().toString())
                if (imageUri != null) nextPhaze.putExtra("imgUri", imageUri.toString())
                startActivity(nextPhaze)
            }
        })
        mMailView.setOnEditorActionListener(object : OnEditorActionListener() {
            @Override
            fun onEditorAction(textView: TextView, id: Int, keyEvent: KeyEvent?): Boolean {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(textView.getText().toString()).matches()) {
                        textView.setError("E-Mail Wrong!")
                    }
                    return true
                }
                textView.setError(null)
                return false
            }
        })
        mTelView.setOnEditorActionListener(object : OnEditorActionListener() {
            @Override
            fun onEditorAction(textView: TextView, id: Int, keyEvent: KeyEvent?): Boolean {
                if (!Patterns.PHONE.matcher(mTelView.getText().toString()).matches()) {
                    textView.setError("Enter Correct Phone Number")
                } else {
                    textView.setError(null)
                }
                return false
            }
        })
        mTcView.setOnEditorActionListener(object : OnEditorActionListener() {
            @Override
            fun onEditorAction(textView: TextView, id: Int, keyEvent: KeyEvent?): Boolean {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    return if (textView.getText().toString().length() !== 11) {
                        textView.setError("Error!!")
                        false
                    } else true
                }

                //  textView.setError(null);
                if (textView.getText().toString().length() !== 11) {
                    textView.setError("Error")
                } else {
                    textView.setError(null)
                }
                return false
            }
        })
    }

    @Override
    fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == OPEN_IMG_CODE && resultCode == RESULT_OK) {
            if (resultData != null) {
                imageUri = resultData.getData()
                val uri: Uri = resultData.getData()
                try {
                    val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri)
                    mImgBtn.setImageBitmap(bitmap)
                    Toast.makeText(getApplicationContext(), "Image Set " + imageUri.toString(), Toast.LENGTH_SHORT).show()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
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
        } else {
            true
        }
    }
}