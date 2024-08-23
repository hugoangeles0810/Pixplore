package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import io.github.hugoangeles0810.pixplore.data.entities.Photo

private const val Columns = 3
private val GridSeparation = 20.dp

@Composable
fun PhotoGrid(
    modifier: Modifier = Modifier,
    lazyPagingItems: LazyPagingItems<Photo>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(Columns),
        verticalArrangement = Arrangement.spacedBy(GridSeparation),
        horizontalArrangement = Arrangement.spacedBy(GridSeparation),
        contentPadding = PaddingValues(top = 32.dp)
    ) {
        items(lazyPagingItems.itemCount) { index ->
            lazyPagingItems[index]?.let {
                PhotoCard(
                    user = it.username,
                    createdAt = it.createdAt,
                    tags = it.tags,
                    url = it.url
                )
            }
        }

        lazyPagingItems.apply {
            if (loadState.append is LoadState.Loading) {
                item {
                    NextPhotosPageSkeleton(columns = Columns)
                }
            }
        }
    }
}