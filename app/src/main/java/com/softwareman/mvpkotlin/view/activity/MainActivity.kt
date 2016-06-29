package com.softwareman.mvpkotlin.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.softwareman.mvpkotlin.R
import com.softwareman.mvpkotlin.model.User
import com.softwareman.mvpkotlin.presenter.CreateUserPresenter
import com.softwareman.mvpkotlin.presenter.CreateUserPresenterImpl
import com.softwareman.mvpkotlin.utils.textValue
import com.softwareman.mvpkotlin.view.CreateUserView
import com.softwareman.mvpkotlin.view.USER_KEY
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), CreateUserView {

    private val presenter: CreateUserPresenter<CreateUserView> by lazy {
        CreateUserPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveUserBtn.setOnClickListener{
            presenter.saveUser(userName.textValue(), userSurname.textValue()) /*use of textValue() extension, mentioned earlier */
        }
    }

    override fun showEmptyNameError() {
        userName.error = getString(R.string.name_empty_error) /* it's equal to userName.setError() - Kotlin allows to use property */
    }

    override fun showEmptySurnameError() {
        userSurname.error = getString(R.string.surname_empty_error)
    }

    override fun showUserSaved() {
        toast(R.string.user_saved) /* anko extension - equal to Toast.makeText(this, R.string.user_saved, Toast.LENGTH_LONG) */
    }

    override fun showUserDetails(user: User) {
        startActivity<UserDetailsActivity>(USER_KEY to user) /* anko extension - starts UserDetailsActivity and pass user as USER_KEY in intent */
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
