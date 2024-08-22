package io.github.hugoangeles0810.pixplore.domain.usecase

import androidx.paging.PagingData
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 15

class FetchPhotos @Inject constructor(
    private val photoRepository: PhotoRepository
) {

    operator fun invoke(term: String = ""): Flow<PagingData<Photo>> {
        return photoRepository.fetchPhotos(term = term, count = PAGE_SIZE)
    }
}