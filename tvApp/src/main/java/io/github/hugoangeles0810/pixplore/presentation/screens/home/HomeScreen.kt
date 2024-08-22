package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.hugoangeles0810.pixplore.presentation.components.Error
import io.github.hugoangeles0810.pixplore.presentation.components.Loading
import io.github.hugoangeles0810.pixplore.presentation.components.PhotoGrid


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val s = uiState) {
            is HomeScreenUiState.Ready -> {
                PhotoGrid(lazyPagingItems = s.photos.collectAsLazyPagingItems())
            }
            is HomeScreenUiState.Loading -> {
                Loading(modifier = Modifier.fillMaxSize())
            }
            is HomeScreenUiState.Error -> {
                Error(modifier = Modifier.fillMaxSize())
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }
}