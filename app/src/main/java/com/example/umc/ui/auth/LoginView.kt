package com.example.umc.ui.auth

import com.example.umc.data.remote.Result

interface LoginView {
    fun onLoginSuccess(code : Int, result : Result)
    fun onLoginFailure()
}