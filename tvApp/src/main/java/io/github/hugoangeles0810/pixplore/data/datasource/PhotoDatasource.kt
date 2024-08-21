package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.github.hugoangeles0810.pixplore.data.entities.Photo

interface PhotoDatasource {

    suspend fun fetchPhotos(
        orientation: Orientation,
        count: Int
    ): List<Photo>
}