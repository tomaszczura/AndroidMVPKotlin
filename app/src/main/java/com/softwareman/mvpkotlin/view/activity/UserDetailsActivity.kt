package com.softwareman.mvpkotlin.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.softwareman.mvpkotlin.R
import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.presenter.UserDetailsPresenter
import com.softwareman.mvpkotlin.presenter.UserDetailsPresenterImpl
import com.softwareman.mvpkotlin.view.USER_KEY
import com.softwareman.mvpkotlin.view.UserDetailsView
import kotlinx.android.synthetic.main.activity_user_details.*
import org.jetbrains.anko.toast

class UserDetailsActivity: AppCompatActivity(), UserDetailsView {

    private val presenter: UserDetailsPresenter<UserDetailsView> by lazy {
        UserDetailsPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val user = intent.getParcelableExtra<User>(USER_KEY)
        presenter.user = user
    }

    override fun showUserDetails(user: User) {
        userFullName.text = "${user.name} ${user.surname}"
    }

    override fun showNoUserError() {
        toast(R.string.no_user_error)
        finish()
    }

    override fun onDestroy() {
        presenter.onDestroy()
    }

}
