package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface UnplashApiClient {

    @GET("photos")
    suspend fun fetchRandomPhotos(
        @Query("per_page") count: Int,
        @Query("page") page: Int
    ): List<PhotoDTO>
}