package io.github.hugoangeles0810.pixplore.presentation.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.R
import io.github.hugoangeles0810.pixplore.presentation.components.Error
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
                if (term.isNotEmpty()) {
                    viewModel.query(term)
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            when (val state = uiState) {
                is SearchScreenUiState.Loading -> {
                    Loading(modifier = Modifier.fillMaxSize())
                }
                is SearchScreenUiState.Error -> {
                    Error(modifier = Modifier.fillMaxSize())
                }
                is SearchScreenUiState.Done -> {
                    val lazyPagingItems = state.photos.collectAsLazyPagingItems()
                    Column {

                        if (state.term.isNotEmpty()) {
                            if (lazyPagingItems.itemCount <= 0) {
                                Text(
                                    text = stringResource(id = R.string.search_screen_empty_results_for, state.term),
                                    modifier = Modifier
                                        .padding(bottom = 16.dp)
                                )
                            } else {
                                Text(
                                    text = stringResource(id = R.string.search_screen_results_for, state.term),
                                    modifier = Modifier
                                        .padding(bottom = 16.dp)
                                )
                            }
                        }

                        PhotoGrid(lazyPagingItems = lazyPagingItems)
                    }

                }
            }
        }
    }
}