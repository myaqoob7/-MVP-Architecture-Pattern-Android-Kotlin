package com.orbital.sonic.mvparchitechture

import android.os.Handler
import android.os.Looper

class LoginPresenter(loginResultInterface: LoginResultInterface): LoginPresenterInterface {

    var mLoginResultInterface:LoginResultInterface=loginResultInterface

    override fun doLogin(userName: String, password: String) {
        val userModel=UserModel(userName,password)
        val isLoginSuccess = userModel.checkUserValidity(userName, password)

        Handler(Looper.getMainLooper()).postDelayed({
            mLoginResultInterface.onLoginResult(isLoginSuccess)

        }, 5000)
    }

    override fun setProgressBarVisibility(visibility: Int) {
        mLoginResultInterface.onSetProgressBarVisibility(visibility)
    }
}