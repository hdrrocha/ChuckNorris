package com.example.chucknorris.api

import com.example.chucknorris.model.Categories
import com.example.chucknorris.model.Category
import io.reactivex.Observable
import javax.inject.Inject

class ApiClient @Inject constructor(private val chuckNorrisIOApi: ChuckNorrisIOApi) {
    fun categories(): Observable<List<String>> {
        return chuckNorrisIOApi.categories()
    }
    fun category(categoryId: String): Observable<Category> {
        return chuckNorrisIOApi.category(categoryId)
    }

}