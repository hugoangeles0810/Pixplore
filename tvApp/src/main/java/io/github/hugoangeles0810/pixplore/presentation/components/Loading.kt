package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.R

@Composable
fun Loading(
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.displayMedium,
    message: String = stringResource(id = R.string.loading_message)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = style
        )
    }
}