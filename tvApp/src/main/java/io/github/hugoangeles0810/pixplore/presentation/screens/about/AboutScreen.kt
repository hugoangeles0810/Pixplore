package io.github.hugoangeles0810.pixplore.presentation.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.R
import io.github.hugoangeles0810.pixplore.presentation.components.PixploreLogo

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PixploreLogo(modifier = Modifier.width(130.dp))
        Spacer(modifier = Modifier.height(58.dp))
        Text(
            text = stringResource(id =  R.string.about_screen_description),
            style = MaterialTheme.typography.headlineSmall

        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.about_screen_made_by),
            style = MaterialTheme.typography.labelMedium
        )
    }
}