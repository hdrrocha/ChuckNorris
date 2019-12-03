package com.example.chucknorris.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorris.SchedulerProvider
import com.example.chucknorris.api.ApiClient
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    private val _data = MutableLiveData<List<String>>()
    val data: LiveData<List<String>> = _data
    private val disposable = CompositeDisposable()

    fun fethCategories() {
        disposable.add(
            api.categories().subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    _data.value = emptyList()
                    Log.e("ERROR", it.message)
                }))
    }
}