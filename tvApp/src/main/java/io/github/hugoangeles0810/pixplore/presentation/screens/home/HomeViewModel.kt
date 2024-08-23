package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.performance.PerformanceTracer
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import io.github.hugoangeles0810.pixplore.domain.usecase.TrackHomeLoaded
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchPhotos: FetchPhotos,
    private val trackHomeLoaded: TrackHomeLoaded,
    private val performanceTracer: PerformanceTracer
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Loading)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    fun initialize() {
        viewModelScope.launch {
            try {
                val trace = performanceTracer.newTrace("home_loaded")
                trace.start()
                val photos = fetchPhotos()
                _uiState.compareAndSet(_uiState.value, HomeScreenUiState.Ready(photos))
                trackHomeLoaded()
                trace.stop()
            } catch (t : Throwable) {
                _uiState.compareAndSet(_uiState.value, HomeScreenUiState.Error)
            }
        }
    }

}

sealed interface HomeScreenUiState {

    data object Loading : HomeScreenUiState
    data object Error : HomeScreenUiState
    data class Ready(
        val photos: Flow<PagingData<Photo>>
    ) : HomeScreenUiState
}