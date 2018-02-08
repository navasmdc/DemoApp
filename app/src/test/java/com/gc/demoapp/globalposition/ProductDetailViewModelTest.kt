package com.gc.demoapp.globalposition

import com.gc.demoapp.*
import com.gc.demoapp.operations.globalposition.viewmodel.*
import com.gc.demoapp.repository.mock.MockRepository
import com.gc.demoapp.repository.model.Product
import org.junit.*
import org.mockito.*
import org.mockito.Mockito.*

class ProductDetailViewModelTest : ViewModelTest() {

    lateinit var viewModel : ProductDetailViewModel
    lateinit var selectedProduct : Product

    @Before
    override fun setupTest() {
        super.setupTest()
        selectedProduct = Mockito.mock(Product::class.java)
        repository = Mockito.mock(MockRepository::class.java, Mockito.CALLS_REAL_METHODS)
        repository.selectedProduct = selectedProduct
        viewModel = ProductDetailViewModel(repository)
        viewModel.viewManager = viewManager
        viewModel.navigationManager = navigationManager
    }

    @Test
    fun saveProduct(){
        viewModel.saveProduct(null)
        verify(selectedProduct).setName(viewModel.alias)
        verify(navigationManager).navigateTo(MyStates.PRODUCT_LIST)
    }
}