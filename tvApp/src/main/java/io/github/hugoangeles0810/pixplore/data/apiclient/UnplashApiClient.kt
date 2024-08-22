package io.github.hugoangeles0810.pixplore.data.apiclient

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import io.github.hugoangeles0810.pixplore.data.datasource.dtos.SearchPhotosDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface UnplashApiClient {

    @GET("photos")
    suspend fun fetchPhotosFromEditorial(
        @Query("per_page") count: Int,
        @Query("page") page: Int
    ): List<PhotoDTO>

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") term: String,
        @Query("per_page") count: Int,
        @Query("page") page: Int
    ): SearchPhotosDTO
}