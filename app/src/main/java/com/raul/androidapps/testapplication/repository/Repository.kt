package com.raul.androidapps.testapplication.repository

import com.raul.androidapps.testapplication.domain.Resource


interface Repository {

    suspend fun getFoo(): Resource<Any>


}