package com.raul.androidapps.testapplication.domain

import androidx.annotation.NonNull
import androidx.annotation.Nullable


class Resource<out T>(@NonNull val status: Status, @Nullable val data: T?, @Nullable val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {

        fun <T> success(data: T? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}