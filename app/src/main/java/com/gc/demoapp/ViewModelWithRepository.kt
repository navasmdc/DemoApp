package com.gc.demoapp

import com.gc.demoapp.injection.AppComponent
import com.gc.demoapp.repository.IRepository
import com.gc.navigationinjector.BaseViewModel
import javax.inject.Inject

/**
 * Created by 674756 on 05/02/2018.
 */
abstract class ViewModelWithRepository : BaseViewModel{

    lateinit var repository : IRepository

    constructor(){
        repository = MyApplication.appComponent.repository()
    }

    constructor(repository : IRepository){
        this.repository = repository
    }

}