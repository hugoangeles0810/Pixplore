package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.datasource.dtos.PhotoDTO
import io.github.hugoangeles0810.pixplore.data.mappers.DateFormatter
import io.github.hugoangeles0810.pixplore.data.mappers.toEntity
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class PhotoMappersKtTest {

    private val photoId = "id"
    private val photoUser = "user"
    private val photoUrl = "any_url"
    private val photoCreatedAt = "2020-06-04T13:44:09Z"

    @Test
    fun `photo dto to entity`() {
        val dateFormatter = DateFormatter(now = { LocalDate.ofYearDay(2024, 1) })
        val dto = PhotoDTO(
            id = photoId,
            createdAt =  photoCreatedAt,
            urls = PhotoDTO.Urls(regular = photoUrl),
            user = PhotoDTO.User(username = photoUser)
        )

        val entity = dto.toEntity(dateFormatter)

        assertEquals(photoId, entity.id)
        assertEquals("3 years ago", entity.createdAt)
        assertEquals(photoUser, entity.username)
        assertEquals(photoUrl, entity.url)
    }
}