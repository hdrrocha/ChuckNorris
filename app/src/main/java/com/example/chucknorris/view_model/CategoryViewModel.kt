package com.example.chucknorris.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorris.SchedulerProvider
import com.example.chucknorris.api.ApiClient
import com.example.chucknorris.model.Category
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    private val _data = MutableLiveData<Category>()
    val data: LiveData<Category> = _data
    private val disposable = CompositeDisposable()

    fun fethCategory(category: String) {
        disposable.add(
            api.category(category).subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    Log.e("ERROR", it.message)
                }))
    }
}