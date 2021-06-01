package com.orbital.sonic.mvparchitechture

interface UserInterface {
    fun getUserName(): String

    fun getUserPassword(): String

    fun checkValidity(userName: String, password: String): Boolean
}