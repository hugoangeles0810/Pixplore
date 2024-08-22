package io.github.hugoangeles0810.pixplore.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.R

@Composable
fun Error(
    modifier: Modifier = Modifier,
    message: String = stringResource(id = R.string.error_message)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.displayMedium,
        )
    }
}