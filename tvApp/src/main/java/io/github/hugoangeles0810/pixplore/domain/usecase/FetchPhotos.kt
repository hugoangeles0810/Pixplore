package io.github.hugoangeles0810.pixplore.domain.usecase

import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.repository.PhotoRepository
import javax.inject.Inject

private const val PAGE_SIZE = 10

class FetchPhotos @Inject constructor(
    private val photoRepository: PhotoRepository
) {

    suspend operator fun invoke(): List<Photo> {
        return photoRepository.fetchPhotos(Orientation.Landscape, count = PAGE_SIZE)
    }
}