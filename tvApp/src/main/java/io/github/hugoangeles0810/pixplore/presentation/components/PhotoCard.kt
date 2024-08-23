package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.CompactCard
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import io.github.hugoangeles0810.pixplore.R
import io.github.hugoangeles0810.pixplore.presentation.theme.PixploreTheme

const val CARD_ASPECT_RATIO = 16f / 9f
private const val SINGLE_LINE = 1

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    itemWidth: Dp = 268.dp,
    user: String,
    createdAt: String,
    tags: String? = null,
    url: String,
    onClick: () -> Unit = {}
) {

    CompactCard(
        modifier = modifier
            .width(itemWidth)
            .aspectRatio(CARD_ASPECT_RATIO),
        onClick = onClick,
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
            AsyncImage(
                model = url,
                contentDescription = user,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.photo_placeholder),
                error = painterResource(id = R.drawable.photo_placeholder),
                modifier = Modifier
                    .fillMaxSize()
            )
        },
        title = {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp
                    )
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = user,
                    style = MaterialTheme.typography.headlineSmall,
                    overflow = TextOverflow.Ellipsis,
                    minLines = SINGLE_LINE,
                    maxLines = SINGLE_LINE
                )
                Text(
                    text = createdAt,
                    style = MaterialTheme.typography.labelLarge,
                    minLines = SINGLE_LINE,
                    maxLines = SINGLE_LINE,
                    modifier = Modifier
                        .graphicsLayer { alpha = 0.6f }
                )
                tags?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall,
                        minLines = SINGLE_LINE,
                        maxLines = SINGLE_LINE,
                        modifier = Modifier
                            .graphicsLayer { alpha = 0.8f }
                    )
                }
            }
        }
    )
}

@Preview(device = Devices.TV_1080p)
@Composable
private fun PhotoCardPreview() {
    PixploreTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            PhotoCard(
                user = "Title",
                createdAt = "01/01/1992",
                tags = "cars • speed",
                url = ""
            )
        }
    }
}
