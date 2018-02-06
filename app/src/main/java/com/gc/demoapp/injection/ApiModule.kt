package com.gc.demoapp.injection

import com.gc.demoapp.repository.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Dagger module for API
 *
 * Created by Jorge Para on 10/30/17.
 * 2017 © Cognizant Technology Solutions
 */
@Module
class ApiModule {

    @AppScope
    @Provides
    fun provideApi(client: OkHttpClient) : Api {
        return Retrofit.Builder().client(client)
                .baseUrl("https://dev-server-demos.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(rxAdapter)
                .build()
                .create(Api::class.java)
    }

}