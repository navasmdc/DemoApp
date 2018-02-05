package com.gc.demoapp.injection

import com.gc.demoapp.BuildConfig
import com.gc.demoapp.repository.*
import dagger.*

@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideRepository(api: Api) : IRepository =
        when (BuildConfig.FLAVOR) {
            "mock" -> com.gc.demoapp.repository.mock.Repository()
            else -> com.gc.demoapp.repository.remote.Repository()
        }

}