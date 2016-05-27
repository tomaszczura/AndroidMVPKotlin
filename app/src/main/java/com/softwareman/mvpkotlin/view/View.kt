package com.softwareman.mvpkotlin.view

import com.softwareman.mvpkotlin.model.User

interface CreateUserView {
    fun showEmptyNameError() /* show error when name is empty */
    fun showEmptySurnameError() /* show error when surname is empty */
    fun showUserSaved() /* show user saved info */
    fun showUserDetails(user: User) /* show user details */
}

interface UserDetailsView {
    fun showUserDetails(user: User)
    fun showNoUserError()
}