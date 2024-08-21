package io.github.hugoangeles0810.pixplore.data.dtos

data class PhotoDTO(
    val id: String,
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