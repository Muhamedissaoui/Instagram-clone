package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//Interface that uses Retrofit to generate implementations
interface UnsplashApi {

    companion object {
        //Static attributes
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    //HTTP request to unsplash API to search for photos
    //Allow the rest of the code to finish even if this function didn't finish yet (suspend)
    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}