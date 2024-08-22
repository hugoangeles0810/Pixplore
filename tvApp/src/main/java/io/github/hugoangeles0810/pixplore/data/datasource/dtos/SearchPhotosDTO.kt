package io.github.hugoangeles0810.pixplore.data.datasource.dtos

data class SearchPhotosDTO(
    val total: Int,
    val totalPages: Int,
    val results: List<PhotoDTO>
)