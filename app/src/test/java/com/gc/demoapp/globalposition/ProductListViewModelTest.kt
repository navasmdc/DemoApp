package com.gc.demoapp.globalposition

import com.gc.demoapp.*
import com.gc.demoapp.operations.globalposition.viewmodel.ProductListViewModel
import com.gc.demoapp.repository.model.Product
import org.junit.*
import org.mockito.Mockito.*

class ProductListViewModelTest : ViewModelTest(){

    lateinit var viewModel : ProductListViewModel

    @Before
    override fun setupTest() {
        super.setupTest()
        viewModel = ProductListViewModel(repository)
        viewModel.viewManager = viewManager
        viewModel.navigationManager = navigationManager
    }

    @Test
    fun selectProduct(){
        viewModel.selectProduct(mock(Product::class.java))
        verify(navigationManager).navigateTo(MyStates.PRODUCT_DETAIL)
    }

}