package io.github.hugoangeles0810.pixplore.data

import io.github.hugoangeles0810.pixplore.data.dtos.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface UnplashApiService {

    @GET("photos/random")
    suspend fun fetchRandomPhotos(
        @Query("orientation") orientation: String,
        @Query("count") count: Int
    ): List<PhotoDTO>
}