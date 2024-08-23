package io.github.hugoangeles0810.pixplore.data.mappers

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import java.time.ZonedDateTime

private val currentDateFormatter = DateFormatter()
private const val TagsLimit = 3

fun List<PhotoDTO>.toEntity(): List<Photo> {
    return map { it.toEntity() }
}

fun PhotoDTO.toEntity(dateFormatter: DateFormatter = currentDateFormatter): Photo {
    return Photo(
        id = id,
        url = urls.regular.orEmpty(),
        username = user.username,
        createdAt = dateFormatter.relativeFormat(from = createdAt.toLocalDate()),
        tags = tags?.take(TagsLimit)?.joinToString(" • ") { it.title }
    )
}

private fun String.toLocalDate() = ZonedDateTime.parse(this).toLocalDate()