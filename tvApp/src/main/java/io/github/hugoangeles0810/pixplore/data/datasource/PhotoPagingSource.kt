package io.github.hugoangeles0810.pixplore.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.hugoangeles0810.pixplore.data.entities.Photo

class PhotoPagingSource(
    private val photoDatasource: PhotoDatasource,
    private val term: String,
    private val pageSize: Int
) : PagingSource<Int, Photo>() {

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val currentPage = params.key ?: 1
            val photos = photoDatasource.fetchPhotos(term, pageSize, currentPage)
            LoadResult.Page(
                data = photos,
                prevKey = (currentPage - 1).takeIf { currentPage > 1 },
                nextKey = (currentPage + 1).takeIf { photos.isNotEmpty() }
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}