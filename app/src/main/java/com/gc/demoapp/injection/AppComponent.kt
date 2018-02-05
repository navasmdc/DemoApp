package com.gc.demoapp.injection

import com.gc.demoapp.repository.IRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@AppScope
@Component(modules = arrayOf(ApiModule::class,
                             AppContextModule::class,
                             NetworkingModule::class,
                             RepositoryModule::class))


interface AppComponent {

    fun repository(): IRepository

}