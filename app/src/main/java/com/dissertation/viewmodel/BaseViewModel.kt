package com.dissertation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val loadingLiveData = MutableLiveData<LoadingEventResponse>()
}