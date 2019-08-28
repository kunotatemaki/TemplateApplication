package com.raul.androidapps.testapplication.repository


import com.raul.androidapps.testapplication.domain.Resource
import com.raul.androidapps.testapplication.network.NetworkServiceFactory
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl @Inject constructor(private val networkServiceFactory: NetworkServiceFactory) :
    Repository {
    override suspend fun getFoo(): Resource<Any> {
        return try {
            val resp = networkServiceFactory.getServiceInstance().getFoo(
                path = "path",
                param1 = 0L,
                param2 = "param2"
            )
            if (resp.isSuccessful && resp.body() != null) {
                Resource.success(resp.body())
            } else {
                Resource.error(resp.message(), null)
            }
        } catch (e: Throwable) {
            Timber.e("Error fetching from network")
            Resource.error(e.message ?: "", null)
        }
    }


}