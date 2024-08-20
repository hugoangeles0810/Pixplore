package io.github.hugoangeles0810.pixplore.presentation.theme

import androidx.compose.foundation.layout.Column
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.presentation.screens.Screens
import io.github.hugoangeles0810.pixplore.presentation.screens.about.AboutScreen
import io.github.hugoangeles0810.pixplore.presentation.screens.home.HomeScreen
import io.github.hugoangeles0810.pixplore.presentation.screens.search.SearchScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TvApp() {

    val navController = rememberNavController()
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(SafeAreaPadding)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .focusRestorer()
        ) {
            Screens.entries.forEachIndexed { index, screen ->
                key(index) {
                    Tab(
                        selected = index == selectedTabIndex,
                        onFocus = {
                            selectedTabIndex = index
                            navController.navigate(Screens.entries[index].route)
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

        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            builder = {
                composable(
                    route = Screens.Home.route
                ) {
                    HomeScreen()
                }
                composable(
                    route = Screens.Search.route
                ) {
                    SearchScreen()
                }
                composable(
                    route = Screens.About.route
                ) {
                    AboutScreen()
                }
            }
        )
    }
}