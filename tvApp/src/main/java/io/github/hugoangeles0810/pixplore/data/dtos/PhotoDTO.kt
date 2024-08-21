package io.github.hugoangeles0810.pixplore.data.dtos

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    val id: String,
    @SerializedName("created_at")
    val createdAt: String,
    val width: Int,
    val height: Int,
    val color: String?,
    val urls: Urls
) {

    data class Urls(
        val raw: String?,
        val full: String?,
        val regular: String?,
        val small: String?,
        val thumb: String?
    )
}