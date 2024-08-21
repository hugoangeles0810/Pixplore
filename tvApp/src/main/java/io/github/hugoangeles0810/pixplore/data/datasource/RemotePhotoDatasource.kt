package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import javax.inject.Inject

class RemotePhotoDatasource @Inject constructor(
    private val apiClient: UnplashApiClient
) : PhotoDatasource {

    override suspend fun fetchPhotos(orientation: Orientation, count: Int): List<Photo> {
        return apiClient.fetchRandomPhotos(orientation.value, count).toEntity()
    }
}