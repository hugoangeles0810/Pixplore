package io.github.hugoangeles0810.pixplore.domain.repository

import io.github.hugoangeles0810.pixplore.data.UnplashApiService
import io.github.hugoangeles0810.pixplore.domain.entities.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val apiService: UnplashApiService
) {

    suspend fun fetchPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            apiService.fetchRandomPhotos("landscape", 10)
                .map { Photo(it.id, it.urls.full.orEmpty(), it.user.username, it.createdAt) }
        }
    }
}