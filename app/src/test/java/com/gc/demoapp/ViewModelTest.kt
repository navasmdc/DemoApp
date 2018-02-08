package com.gc.demoapp

import com.gc.demoapp.repository.IRepository
import com.gc.navigationinjector.*
import org.junit.Before
import org.mockito.Mockito

open class ViewModelTest {

    lateinit var viewManager : ViewManager
    lateinit var navigationManager : NavigationManager
    lateinit var repository : IRepository

    open fun setupTest(){
        repository = Mockito.mock(IRepository::class.java)
        viewManager = Mockito.mock(ViewManager::class.java)
        navigationManager = Mockito.mock(NavigationManager::class.java)

    }

}