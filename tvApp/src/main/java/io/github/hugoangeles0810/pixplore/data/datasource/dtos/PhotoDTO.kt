package io.github.hugoangeles0810.pixplore.data.datasource.dtos

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    val id: String,
    @SerializedName("created_at")
    val createdAt: String,
    val urls: Urls,
    val user: User,
    val tags: List<Tag>? = null
) {

    data class Urls(
        val raw: String? = null,
        val full: String? = null,
        val regular: String? = null,
        val small: String? = null,
        val thumb: String? = null
    )

    data class User(
        val username: String
    )

    data class Tag(
        val title: String
    )
}