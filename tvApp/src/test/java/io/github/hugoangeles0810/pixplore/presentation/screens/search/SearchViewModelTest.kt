package io.github.hugoangeles0810.pixplore.presentation.screens.search

import androidx.paging.PagingData
import io.github.hugoangeles0810.pixplore.CoroutinesTestRule
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val fetchPhotos: FetchPhotos = mockk()

    private val photos = listOf<Photo>(mockk(), mockk())

    @Test
    fun `given a successful photo searching should update the ui state to done`() = runTest {
        coEvery { fetchPhotos(any()) } returns flowOf(PagingData.from(photos))
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is SearchScreenUiState.Done)
        viewModel.query("term")
        assertTrue(viewModel.uiState.value is SearchScreenUiState.Done)
    }

    @Test
    fun `given a failure photo searching should update the ui state to done`() = runTest {
        coEvery { fetchPhotos(any()) } throws  IllegalStateException()
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is SearchScreenUiState.Done)
        viewModel.query("term")
        assertTrue(viewModel.uiState.value is SearchScreenUiState.Error)
    }

    private fun viewModel() = SearchViewModel(fetchPhotos)
}