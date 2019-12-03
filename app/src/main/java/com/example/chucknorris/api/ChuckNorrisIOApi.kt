package com.example.chucknorris.api


import com.example.chucknorris.model.Categories
import com.example.chucknorris.model.Category
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisIOApi {
    companion object {
//        https://api.chucknorris.io/jokes/categories
        const val URL = "https://api.chucknorris.io/jokes/"
    }

//    https://api.chucknorris.io/jokes/
    @GET("categories")
    fun categories(): Observable<List<String>>

//    https://api.chucknorris.io/jokes/random?category={category}
    @GET("random")
    fun category(
         @Query("category") categoryId: String): Observable<Category>


}