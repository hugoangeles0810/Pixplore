package io.github.hugoangeles0810.pixplore.data.mappers

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import java.time.ZonedDateTime

private val dateFormatter = DateFormatter()

fun List<PhotoDTO>.toEntity(): List<Photo> {
    return map { it.toEntity() }
}

fun PhotoDTO.toEntity(): Photo {
    return Photo(
        id = id,
        url = urls.full.orEmpty(),
        username = user.username,
        createdAt = dateFormatter.relativeFormat(from = createdAt.toLocalDate())
    )
}

private fun String.toLocalDate() = ZonedDateTime.parse(this).toLocalDate()