package io.github.hugoangeles0810.pixplore.domain.repository

import io.github.hugoangeles0810.pixplore.data.datasource.PhotoDatasource
import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.github.hugoangeles0810.pixplore.di.IoDispatcher
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val datasource: PhotoDatasource,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchPhotos(orientation: Orientation, count: Int): List<Photo> {
        return withContext(ioDispatcher) {
            datasource.fetchPhotos(orientation, count)
        }
    }
}