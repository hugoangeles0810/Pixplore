package io.github.hugoangeles0810.pixplore.infrastructure

import io.github.hugoangeles0810.pixplore.infrastructure.dtos.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface UnplashApiService {

    @GET("photos/random")
    suspend fun fetchRandomPhotos(
        @Query("orientation") orientation: String,
        @Query("count") count: Int
    ): List<PhotoDTO>
}