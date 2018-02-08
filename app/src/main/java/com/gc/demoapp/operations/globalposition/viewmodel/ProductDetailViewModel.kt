package com.gc.demoapp.operations.globalposition.viewmodel

import android.view.View
import com.gc.demoapp.*
import com.gc.demoapp.repository.IRepository
import com.gc.demoapp.repository.model.Product
import com.gc.navigationinjector.BaseViewModel

class ProductDetailViewModel : ViewModelWithRepository {

    constructor()

    constructor(repository : IRepository) : super(repository)

    override fun getLayout() : Int = R.layout.product_detail_state

    var alias : String
    var selectedProduct : Product

    init {
        selectedProduct = repository.selectedProduct!!
        alias = repository.selectedProduct!!.getName()
    }

    fun saveProduct(v : View?) {
        repository.selectedProduct!!.setName(alias)
        navigationManager.navigateTo(MyStates.PRODUCT_LIST)
    }

}