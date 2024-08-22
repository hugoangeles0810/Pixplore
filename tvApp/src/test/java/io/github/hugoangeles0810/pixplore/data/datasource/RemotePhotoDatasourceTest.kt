package io.github.hugoangeles0810.pixplore.data.datasource

import io.github.hugoangeles0810.pixplore.data.apiclient.UnplashApiClient
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
        photoDatasource.fetchPhotos(term = "", count = 10, page = 1)

        coVerify { apiClient.fetchPhotosFromEditorial(count = 10, page = 1) }
    }

    @Test
    fun `fetch photos with a term should invoke api client with expected params`() = runTest {
        photoDatasource.fetchPhotos(term = "term", count = 10, page = 1)

        coVerify { apiClient.searchPhotos(term = "term", count = 10, page = 1) }
    }
}