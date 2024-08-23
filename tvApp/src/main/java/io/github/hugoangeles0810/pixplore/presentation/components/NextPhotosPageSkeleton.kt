package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.CompactCard
import androidx.tv.material3.MaterialTheme
import io.github.hugoangeles0810.pixplore.R
import io.github.hugoangeles0810.pixplore.presentation.theme.PixploreTheme

fun LazyGridScope.nextPhotosPageSkeleton(
    modifier: Modifier = Modifier,
    itemWidth: Dp = 268.dp,
    columns: Int
) {

    items(columns) {
        CompactCard(
            modifier = modifier
                .width(itemWidth)
                .aspectRatio(CARD_ASPECT_RATIO),
            onClick = {},
            scale = CardDefaults.scale(focusedScale = 1f),
            border = CardDefaults.border(
                focusedBorder = Border(
                    border = BorderStroke(
                        width = 3.dp, color = MaterialTheme.colorScheme.onSurface
                    )
                )
            ),
            colors = CardDefaults.colors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),
            image = {
                Image(
                    painter = painterResource(id = R.drawable.photo_placeholder),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            },
            title = {}
        )
    }
}

@Preview(device = Devices.TV_1080p)
@Composable
private fun NextPhotosPageSkeletonPreview() {
    PixploreTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                nextPhotosPageSkeleton(columns = 3)
            }
        }
    }
}