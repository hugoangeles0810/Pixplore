package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hugoangeles0810.pixplore.domain.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    val uiState: StateFlow<HomeScreenUiState> =  flow {
        emit(repository.fetchPhotos())
    }.map {
        HomeScreenUiState.Ready(it)
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