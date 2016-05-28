package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.model.UserError
import com.softwareman.mvpkotlin.model.UserStore
import com.softwareman.mvpkotlin.model.UserValidator
import com.softwareman.mvpkotlin.view.CreateUserView

class CreateUserPresenterImpl(override var view: CreateUserView?): CreateUserPresenter<CreateUserView> {

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