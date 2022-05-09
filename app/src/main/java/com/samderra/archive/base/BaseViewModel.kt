package com.samderra.archive.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    val compositeDisposable: CompositeDisposable by lazy(::CompositeDisposable)
    val isProcessing by lazy { MutableLiveData<Boolean>(false) }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    open fun clear() {
//        onCleared()
    }

    fun beginProcess() {
        isProcessing.postValue(true)
    }

    fun endProcess() {
        isProcessing.postValue(false)
    }

    fun toastError(throwable: Throwable) {
        endProcess()
    }

}
