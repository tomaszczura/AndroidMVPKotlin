package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.view.View

interface Presenter<T : View> {
    var view: T?

    fun onDestroy(){
        view = null
    }
}

interface CreateUserPresenter<T : View>: Presenter<T> {
    fun saveUser(name: String, surname: String)
}

interface UserDetailsPresenter<T : View>: Presenter<T> {
    var user: User?
}
