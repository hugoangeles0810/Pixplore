package io.github.hugoangeles0810.pixplore.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.hugoangeles0810.pixplore.presentation.components.PhotoCard


private const val Columns = 3
private val GridSeparation = 20.dp

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
                LazyVerticalGrid(
                    columns = GridCells.Fixed(Columns),
                    verticalArrangement = Arrangement.spacedBy(GridSeparation),
                    horizontalArrangement = Arrangement.spacedBy(GridSeparation)
                ) {
                    items(s.photos) {
                        PhotoCard(user = it.username, createdAt = it.createdAt, url = it.url)
                    }
                }
            }
            is HomeScreenUiState.Loading -> {
                // TODO: Add loading skeleton
            }
            is HomeScreenUiState.Error -> {
                // TODO: Add error ui
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }
}