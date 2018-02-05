package com.gc.demoapp.injection

import android.content.Context
import com.gc.demoapp.BuildConfig
import com.gc.demoapp.repository.mock.MockInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@Module
class NetworkingModule {

    @AppScope
    @Provides
    internal fun provideHttpClient(interceptor : Interceptor, cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    internal fun provideLoggingInterceptor(): Interceptor =
        when(BuildConfig.FLAVOR){
            "mock" -> MockInterceptor()
            else -> {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                httpLoggingInterceptor
            }
        }

    @AppScope
    @Provides
    internal fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    @AppScope
    @Provides
    internal fun provideCacheFile(context: Context): File {
        return context.filesDir
    }


    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}