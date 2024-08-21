package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchPhotos: FetchPhotos
) : ViewModel() {

    val uiState: StateFlow<HomeScreenUiState> = flow {
        emit(fetchPhotos())
    }.map {
        HomeScreenUiState.Ready(it) as HomeScreenUiState
    }.catch {
        emit(HomeScreenUiState.Error)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeScreenUiState.Loading
    )

}

sealed interface HomeScreenUiState {

    data object Loading : HomeScreenUiState
    data object Error : HomeScreenUiState
    data class Ready(
        val photos: List<Photo>
    ) : HomeScreenUiState
}