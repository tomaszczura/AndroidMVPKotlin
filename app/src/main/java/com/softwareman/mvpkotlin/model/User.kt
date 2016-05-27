package com.softwareman.mvpkotlin.model

import android.os.Parcel
import android.os.Parcelable

data class User(val name: String, val surname: String) : Parcelable{
    constructor(source: Parcel): this(source.readString(), source.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(surname)
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User {
                return User(source)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }
}

enum class UserError {
    EMPTY_NAME,
    EMPTY_SURNAME,
    NO_ERROR
}

object UserStore {
    fun saveUser(user: User){
        //Save user somewhere: Database, SharedPreferences, send to web...
    }
}

object UserValidator {

    fun validateUser(user: User): UserError {
        with(user){
            if(name.isNullOrEmpty()) return UserError.EMPTY_NAME
            if(surname.isNullOrEmpty()) return UserError.EMPTY_SURNAME
        }

        return UserError.NO_ERROR
    }
}
