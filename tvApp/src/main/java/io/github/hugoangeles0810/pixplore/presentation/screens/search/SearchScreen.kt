package io.github.hugoangeles0810.pixplore.presentation.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.hugoangeles0810.pixplore.presentation.components.Loading
import io.github.hugoangeles0810.pixplore.presentation.components.PhotoGrid
import io.github.hugoangeles0810.pixplore.presentation.components.SearchBar

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {

    var searchQuery by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            searchQuery = searchQuery,
            onValueChange = { newQuery -> searchQuery = newQuery },
            onSearch = { term ->
                viewModel.query(term)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            when (val state = uiState) {
                is SearchScreenUiState.Loading -> {
                    Loading(modifier = Modifier.fillMaxSize())
                }
                is SearchScreenUiState.Done -> {
                    val lazyPagingItems = state.photos.collectAsLazyPagingItems()
                    PhotoGrid(lazyPagingItems = lazyPagingItems)
                }
            }
        }
    }
}