package io.github.hugoangeles0810.pixplore.domain.repository

import io.github.hugoangeles0810.pixplore.infrastructure.UnplashApiClient
import io.github.hugoangeles0810.pixplore.di.IoDispatcher
import io.github.hugoangeles0810.pixplore.domain.entities.Photo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val apiService: UnplashApiClient,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchPhotos(): List<Photo> {
        return withContext(ioDispatcher) {
            apiService.fetchRandomPhotos("landscape", 10)
                .map { Photo(it.id, it.urls.full.orEmpty(), it.user.username, it.createdAt) }
        }
    }
}