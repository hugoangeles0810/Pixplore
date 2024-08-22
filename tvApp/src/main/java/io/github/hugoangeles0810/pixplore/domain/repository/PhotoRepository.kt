package io.github.hugoangeles0810.pixplore.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.hugoangeles0810.pixplore.data.datasource.PhotoDatasource
import io.github.hugoangeles0810.pixplore.data.datasource.PhotoPagingSource
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val datasource: PhotoDatasource
) {

    suspend fun fetchPhotos(count: Int): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = count, prefetchDistance = 3),
            pagingSourceFactory = {
                PhotoPagingSource(datasource, count)
            }
        ).flow
    }
}