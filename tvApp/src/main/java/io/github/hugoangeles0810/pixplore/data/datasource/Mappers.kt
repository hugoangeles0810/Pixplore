package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import io.github.hugoangeles0810.pixplore.data.entities.Photo

fun List<PhotoDTO>.toEntity(): List<Photo> {
    return map { it.toEntity() }
}

fun PhotoDTO.toEntity(): Photo {
    return Photo(
        id = id,
        url = urls.full.orEmpty(),
        username = user.username,
        createdAt = createdAt
    )
}