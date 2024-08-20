package io.github.hugoangeles0810.pixplore.presentation.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.presentation.screens.Screens

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TvApp() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(SafeAreaPadding)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.focusRestorer()
        ) {
            Screens.entries.forEachIndexed { index, screen ->
                key(index) {
                    Tab(
                        selected = index == selectedTabIndex,
                        onFocus = {
                            selectedTabIndex = index
                        }
                    ) {
                        Text(
                            text = stringResource(id = screen.title),
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = LocalContentColor.current
                            ),
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}