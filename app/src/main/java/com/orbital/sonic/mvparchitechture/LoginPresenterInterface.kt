package com.orbital.sonic.mvparchitechture

interface LoginPresenterInterface {
    fun doLogin(userName: String, password: String)
    fun setProgressBarVisibility(visibility: Int)
}