package com.softwareman.mvpkotlin.presenter

import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.view.UserDetailsView

class UserDetailsPresenterImpl(var view: UserDetailsView?): UserDetailsPresenter {
    override var user: User? = null
        set(value) {
            field = value
            if(field != null){
                view?.showUserDetails(field!!)
            } else {
                view?.showNoUserError()
            }
        }

    override fun onDestroy() {
        view = null
    }


    override fun onCreate() {}
    override fun onStart() {}
    override fun onResume() {}
    override fun onPause() {}
    override fun onStop() {}


}
