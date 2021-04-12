package com.felbsn.odev2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.EditorInfo
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginScreen : AppCompatActivity() {
    var _userName = "admin"
    var _password = "password"
    var mUserNameView: AutoCompleteTextView? = null
    var mPasswordView: EditText? = null
    var mProgressView: View? = null
    var mLoginFormView: View? = null
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        setTitle("Login Screen")
        mUserNameView = findViewById(R.id.email) as AutoCompleteTextView?
        mPasswordView = findViewById(R.id.password) as EditText?
        mPasswordView.setOnEditorActionListener(object : OnEditorActionListener() {
            @Override
            fun onEditorAction(textView: TextView?, id: Int, keyEvent: KeyEvent?): Boolean {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin()
                    return true
                }
                return false
            }
        })
        val mEmailSignInButton: Button = findViewById(R.id.email_sign_in_button) as Button
        mEmailSignInButton.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(view: View?) {
                attemptLogin()
            }
        })
        mLoginFormView = findViewById(R.id.login_form)
        mProgressView = findViewById(R.id.login_progress)
    }

    private fun attemptLogin() {

        // Reset errors.
        mUserNameView.setError(null)
        mPasswordView.setError(null)

        // Store values at the time of the login attempt.
        val username: String = mUserNameView.getText().toString()
        val password: String = mPasswordView.getText().toString()
        var cancel = false
        var focusView: View? = null
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_empty_password))
            focusView = mPasswordView
            cancel = true
        }
        if (TextUtils.isEmpty(username)) {
            mUserNameView.setError(getString(R.string.error_empty_username))
            focusView = mUserNameView
            cancel = true
        }
        if (cancel) {
            focusView.requestFocus()
        } else {
            if (username.equals(_userName) && password.equals(_password)) {
                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show()
                val i = Intent(getApplicationContext(), InputActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_LONG).show()
            }
        }
    }
}