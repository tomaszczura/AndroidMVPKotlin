package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User

interface Presenter {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}

interface CreateUserPresenter: Presenter {
    fun saveUser(name: String, surname: String)
}

interface UserDetailsPresenter: Presenter {
    var user: User?
}
