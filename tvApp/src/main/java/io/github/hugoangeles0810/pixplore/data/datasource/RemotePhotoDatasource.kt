package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.apiclient.UnplashApiClient
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.data.mappers.photosDtoToEntity
import io.github.hugoangeles0810.pixplore.data.mappers.searchDtoToEntity
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

    override suspend fun fetchPhotos(
        term: String,
        count: Int,
        page: Int
    ): List<Photo> {
        return withContext(ioDispatcher) {
            if (term.isBlank())
                apiClient.fetchPhotosFromEditorial(count, page).photosDtoToEntity()
            else
                apiClient.searchPhotos(term, count, page).searchDtoToEntity()
        }
    }
}