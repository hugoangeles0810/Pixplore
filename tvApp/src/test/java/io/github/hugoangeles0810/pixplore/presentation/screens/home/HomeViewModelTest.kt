package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.paging.PagingData
import io.github.hugoangeles0810.pixplore.CoroutinesTestRule
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.crashreporting.ErrorReporter
import io.github.hugoangeles0810.pixplore.domain.performance.PerformanceTracer
import io.github.hugoangeles0810.pixplore.domain.performance.Trace
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import io.github.hugoangeles0810.pixplore.domain.usecase.TrackHomeLoaded
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val fetchPhotos: FetchPhotos = mockk()
    private val trackHomeLoaded: TrackHomeLoaded = mockk(relaxed = true)
    private val performanceTracer: PerformanceTracer = mockk(relaxed = true)
    private val errorReporter: ErrorReporter = mockk(relaxed = true)

    private val photos = listOf<Photo>(mockk(), mockk())

    @Test
    fun `given an initial successful fetching photos result should update the ui state to ready`() = runTest {
        coEvery { fetchPhotos() } returns flowOf(PagingData.from(photos))
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is HomeScreenUiState.Loading)
        viewModel.initialize()
        assertTrue(viewModel.uiState.value is HomeScreenUiState.Ready)
    }

    @Test
    fun `on initialize should track home loaded`() = runTest {
        coEvery { fetchPhotos() } returns flowOf(PagingData.from(photos))
        val viewModel = viewModel()

        viewModel.initialize()

        verify(exactly = 1) { trackHomeLoaded() }
    }

    @Test
    fun `on initialize should measure home loaded`() = runTest {
        val trace = mockk<Trace>(relaxed = true)
        every { performanceTracer.newTrace(any()) } returns trace
        coEvery { fetchPhotos() } returns flowOf(PagingData.from(photos))
        val viewModel = viewModel()

        viewModel.initialize()

        verify(exactly = 1) {
            trace.start()
            trace.stop()
        }
    }

    @Test
    fun `given an failure fetching photos result should update the ui state to error`() = runTest {
        coEvery { fetchPhotos() } throws  IllegalStateException()
        val viewModel = viewModel()

        assertTrue(viewModel.uiState.value is HomeScreenUiState.Loading)
        viewModel.initialize()
        assertTrue(viewModel.uiState.value is HomeScreenUiState.Error)
    }

    @Test
    fun `given an error on initialize should report it as handled exception`() = runTest {
        coEvery { fetchPhotos() } throws  IllegalStateException()
        val viewModel = viewModel()

        viewModel.initialize()
        verify { errorReporter.report(any(), handled = true) }
    }

    private fun viewModel() = HomeViewModel(fetchPhotos, trackHomeLoaded, performanceTracer, errorReporter)

}