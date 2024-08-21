package io.github.hugoangeles0810.pixplore.domain.usecase

import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.github.hugoangeles0810.pixplore.domain.repository.PhotoRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FetchPhotosTest {

    private val repository: PhotoRepository = mockk(relaxed = true)

    private lateinit var fetchPhotos: FetchPhotos

    @Before
    fun setUp() {
        fetchPhotos = FetchPhotos(repository)
    }

    @Test
    fun `fetch photos should request landscape orientation and a limited count`() = runTest {
        fetchPhotos()

        coVerify { repository.fetchPhotos(orientation = Orientation.Landscape,  count = 10) }
    }
}