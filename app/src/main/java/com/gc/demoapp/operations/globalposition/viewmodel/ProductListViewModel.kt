package com.gc.demoapp.operations.globalposition.viewmodel

import com.gc.databinidingadapters.OnItemClickListener
import com.gc.demoapp.*
import com.gc.demoapp.repository.IRepository
import com.gc.demoapp.repository.model.Product

class ProductListViewModel : ViewModelWithRepository {

    constructor()

    constructor(repository : IRepository) : super(repository)

    override fun getLayout() : Int = R.layout.product_list_state

    var userName : String? = null

    var products : MutableList<Product>


    init {
        userName = repository.globalPosition?.name
        products = ArrayList()
        if(repository.globalPosition  != null && repository.globalPosition?.accounts != null)
            products.addAll(repository.globalPosition!!.accounts)
        if(repository.globalPosition  != null && repository.globalPosition?.cards != null)
            products.addAll(repository.globalPosition!!.cards)
    }

    var itemClickListener = object  : OnItemClickListener<Product>{
        override fun onItemClick(item : Product) {
            selectProduct(item)
        }

    }

    fun selectProduct(item : Product){
        repository.selectedProduct = item
        navigationManager.navigateTo(MyStates.PRODUCT_DETAIL)
    }



}