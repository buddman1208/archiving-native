package com.samderra.archive.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samderra.archive.util.Event
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    val compositeDisposable: CompositeDisposable by lazy(::CompositeDisposable)
    val isProcessing by lazy { MutableLiveData<Boolean>(false) }

    val messageEvent: MutableLiveData<Event<String>> = MutableLiveData()
    val errorMessageEvent: MutableLiveData<Event<String>> = MutableLiveData()

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

    fun <T> Observable<T>.subscribeAuto(onNext: (T) -> Unit): Disposable {
        return this
            .subscribe(onNext, {
                errorMessageEvent.value = it.message
            })
    }
}
