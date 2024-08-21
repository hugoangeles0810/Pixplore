package io.github.hugoangeles0810.pixplore.domain.repository

import io.github.hugoangeles0810.pixplore.data.datasource.PhotoDatasource
import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class PhotoRepositoryTest {

    private val datasource: PhotoDatasource = mockk(relaxed = true)

    private lateinit var repository: PhotoRepository

    @Before
    fun setUp() {
        repository = PhotoRepository(datasource)
    }

    @Test
    fun `fetch photos should delegate invocation to datasource with expected params`() = runTest {
        repository.fetchPhotos(Orientation.Portrait, 20)

        coVerify { datasource.fetchPhotos(orientation = Orientation.Portrait, count = 20) }
    }
}