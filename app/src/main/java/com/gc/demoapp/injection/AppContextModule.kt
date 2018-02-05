package com.gc.demoapp.injection

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(context: Context) {

    private val context: Context

    init {
        this.context = context
    }

    @AppScope
    @Provides
    internal fun provideAppContext(): Context {
        return context
    }

}