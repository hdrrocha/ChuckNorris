package com.example.chucknorris.api


import com.example.chucknorris.model.Categories
import com.example.chucknorris.model.Category
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckNorrisIOApi {
    companion object {
//        https://api.chucknorris.io/jokes/categories
        const val URL = "https://api.chucknorris.io/"
    }

//    https://api.chucknorris.io/jokes/
    @GET("jokes/categories")
    fun categories(): Observable<List<String>>

    @GET("jokes/random?category={category_id}")
    fun category(
         @Path("category_id") categoryId: String): Observable<Category>


}