package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.model.UserError
import com.softwareman.mvpkotlin.model.UserStore
import com.softwareman.mvpkotlin.model.UserValidator
import com.softwareman.mvpkotlin.view.CreateUserView

class CreateUserPresenterImpl(var view: CreateUserView?): CreateUserPresenter {

    override fun onCreate() {}

    override fun onStart() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onStop() {}

    override fun onDestroy() {
        view = null
    }

    override fun saveUser(name: String, surname: String) {
        val user = User(name, surname)
        when(UserValidator.validateUser(user)){
            UserError.EMPTY_NAME -> view?.showEmptyNameError()
            UserError.EMPTY_SURNAME -> view?.showEmptySurnameError()
            UserError.NO_ERROR -> {
                UserStore.saveUser(user)
                view?.showUserSaved()
                view?.showUserDetails(user)
            }
        }
    }

}