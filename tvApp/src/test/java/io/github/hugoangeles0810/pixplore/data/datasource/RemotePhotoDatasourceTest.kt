package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.entities.Orientation
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class RemotePhotoDatasourceTest {

    private val apiClient: UnplashApiClient = mockk(relaxed = true)

    private lateinit var photoDatasource: PhotoDatasource

    @Before
    fun setUp() {
        photoDatasource = RemotePhotoDatasource(apiClient)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `fetch photos should invoke api client with expected params`() = runTest {
        photoDatasource.fetchPhotos(orientation = Orientation.Landscape, count = 10)

        coVerify { apiClient.fetchRandomPhotos(orientation = "landscape", count = 10) }
    }
}