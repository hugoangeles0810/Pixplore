package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import org.junit.Assert.*
import org.junit.Test

class MappersKtTest {

    private val photoId = "id"
    private val photoUser = "user"
    private val photoUrl = "any_url"
    private val photoCreatedAt = "01/01/10"

    @Test
    fun `photo dto to entity`() {
        val dto = PhotoDTO(
            id = photoId,
            createdAt =  photoCreatedAt,
            urls = PhotoDTO.Urls(full = photoUrl),
            user = PhotoDTO.User(username = photoUser)
        )

        val entity = dto.toEntity()

        assertEquals(photoId, entity.id)
        assertEquals(photoCreatedAt, entity.createdAt)
        assertEquals(photoUser, entity.username)
        assertEquals(photoUrl, entity.url)
    }
}