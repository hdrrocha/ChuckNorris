package com.example.chucknorris.api


import com.example.chucknorris.model.Categories
import com.example.chucknorris.model.Category
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckNorrisIOApi {
    companion object {
        const val URL = "https://api.chucknorris.io/"
    }

    @GET("categories")
    fun categories(): Observable<List<Categories>>

    @GET("jokes/random?category={category_id}")
    fun category(
         @Path("category_id") categoryId: String): Observable<Category>


}