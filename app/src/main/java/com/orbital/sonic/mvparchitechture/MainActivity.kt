package com.orbital.sonic.mvparchitechture

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() ,LoginResultInterface{
    private lateinit var editUserName: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var mLoginPresenter: LoginPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnLogin.setOnClickListener {
            loginResult()
        }

    }

    private fun initViews(){
        editUserName = findViewById(R.id.et_name)
        editPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.bt_submit)
        progressBar = findViewById(R.id.progress_login)
        mLoginPresenter = LoginPresenter(this)
        progressBar.visibility = View.GONE
    }

    private fun loginResult() {
        mLoginPresenter.setProgressBarVisibility(View.VISIBLE)
        val userName = editUserName.text.toString()
        val password = editPassword.text.toString()
        mLoginPresenter.doLogin(userName, password)
    }

    override fun onLoginResult(result: Boolean) {
        mLoginPresenter.setProgressBarVisibility(View.GONE)
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show()
    }

    override fun onSetProgressBarVisibility(visibility: Int) {
        progressBar.visibility = visibility
    }
}