package io.github.hugoangeles0810.pixplore.presentation.screens.home

import io.github.hugoangeles0810.pixplore.CoroutinesTestRule
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val fetchPhotos: FetchPhotos = mockk()

    private val photos = listOf<Photo>(mockk(), mockk())

    @Test
    fun `given an initial successful fetching photos result should update the ui state to ready`() = runTest {
        coEvery { fetchPhotos() } returns photos
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is HomeScreenUiState.Loading)
        viewModel.initialize()
        assertTrue(viewModel.uiState.value is HomeScreenUiState.Ready)
    }

    @Test
    fun `given an failure fetching photos result should update the ui state to error`() = runTest {
        coEvery { fetchPhotos() } throws  IllegalStateException()
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is HomeScreenUiState.Loading)
        viewModel.initialize()
        assertTrue(viewModel.uiState.value is HomeScreenUiState.Error)
    }

    private fun viewModel() = HomeViewModel(fetchPhotos)

}