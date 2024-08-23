package io.github.hugoangeles0810.pixplore.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hugoangeles0810.pixplore.data.entities.Photo
import io.github.hugoangeles0810.pixplore.domain.usecase.FetchPhotos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val fetchPhotos: FetchPhotos
) : ViewModel() {

    private val _uiState = MutableStateFlow<SearchScreenUiState>(SearchScreenUiState.Done("", flowOf(PagingData.empty())))
    val uiState: StateFlow<SearchScreenUiState> = _uiState.asStateFlow()

    fun query(term: String) {
        viewModelScope.launch {
            try {
                _uiState.compareAndSet(_uiState.value, SearchScreenUiState.Loading)
                val photos = fetchPhotos(term = term)
                _uiState.compareAndSet(_uiState.value, SearchScreenUiState.Done(term, photos))
            } catch (t: Throwable) {
                _uiState.compareAndSet(_uiState.value, SearchScreenUiState.Error)
            }
        }
    }
}

sealed interface SearchScreenUiState {
    data object Loading : SearchScreenUiState
    data object Error : SearchScreenUiState
    data class Done(
        val term: String,
        val photos: Flow<PagingData<Photo>>
    ): SearchScreenUiState
}