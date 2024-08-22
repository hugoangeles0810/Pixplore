package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import io.github.hugoangeles0810.pixplore.R

@Composable
fun PixploreLogo(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.img_logo_horizontal),
        contentDescription = "Pixplore",
        contentScale = ContentScale.Fit
    )
}