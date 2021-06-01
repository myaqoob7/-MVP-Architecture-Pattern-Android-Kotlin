package com.orbital.sonic.mvparchitechture

interface LoginResultInterface {
    fun onLoginResult(result: Boolean)
    fun onSetProgressBarVisibility(visibility: Int)
}