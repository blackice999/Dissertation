package com.dissertation.viewmodel

import androidx.lifecycle.viewModelScope
import com.dissertation.model.product.ProductModel
import kotlinx.coroutines.launch

class SplashViewModel(val productModel: ProductModel) : BaseViewModel() {

    init {
        viewModelScope.launch {
            progressLiveData.value = ProgressViewData(!productModel.init(), "Generated products")
        }
    }
}