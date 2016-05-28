package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.view.UserDetailsView

class UserDetailsPresenterImpl(override var view: UserDetailsView?): UserDetailsPresenter<UserDetailsView> {
    override var user: User? = null
        set(value) {
            field = value
            if(field != null){
                view?.showUserDetails(field!!)
            } else {
                view?.showNoUserError()
            }
        }

}
