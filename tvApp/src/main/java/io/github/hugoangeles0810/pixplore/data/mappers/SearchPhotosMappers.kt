package io.github.hugoangeles0810.pixplore.data.mappers

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.SearchPhotosDTO
import io.github.hugoangeles0810.pixplore.data.entities.Photo

fun SearchPhotosDTO.searchDtoToEntity(): List<Photo> = results.photosDtoToEntity()