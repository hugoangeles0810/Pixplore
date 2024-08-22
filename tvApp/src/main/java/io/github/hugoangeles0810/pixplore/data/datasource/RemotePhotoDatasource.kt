package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.apiclient.UnplashApiClient
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.data.mappers.toEntity
import io.github.hugoangeles0810.pixplore.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemotePhotoDatasource @Inject constructor(
    private val apiClient: UnplashApiClient,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PhotoDatasource {

    override suspend fun fetchPhotos(count: Int, page: Int): List<Photo> {
        return withContext(ioDispatcher) { apiClient.fetchRandomPhotos(count, page).toEntity() }
    }
}