package io.github.hugoangeles0810.pixplore.data.datasource.dtos

import com.google.gson.annotations.SerializedName

data class SearchPhotosDTO(
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val results: List<PhotoDTO>
)