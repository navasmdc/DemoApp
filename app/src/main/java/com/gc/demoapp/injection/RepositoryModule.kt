package com.gc.demoapp.injection

import com.gc.demoapp.BuildConfig
import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.mock.MockInterceptor
import dagger.*
import okhttp3.Interceptor

@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideRepository(api: Api,interceptor : Interceptor) : IRepository =
        when (BuildConfig.FLAVOR) {
            "mock" -> com.gc.demoapp.repository.mock.MockRepository(api, interceptor as MockInterceptor)
            else -> com.gc.demoapp.repository.remote.Repository(api)
        }

}