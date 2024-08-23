package io.github.hugoangeles0810.pixplore.presentation.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.presentation.components.PixploreLogo
import io.github.hugoangeles0810.pixplore.presentation.screens.Screens
import io.github.hugoangeles0810.pixplore.presentation.screens.about.AboutScreen
import io.github.hugoangeles0810.pixplore.presentation.screens.home.HomeScreen
import io.github.hugoangeles0810.pixplore.presentation.screens.search.SearchScreen

private val TopBarTabs = Screens.entries.toList()

@Composable
fun TvApp() {

    val navController = rememberNavController()

    var currentDestination: String? by remember { mutableStateOf(Screens.Home.route) }
    val currentTopBarSelectedTabIndex by remember(currentDestination) {
        derivedStateOf {
            currentDestination?.let { destination -> TopBarTabs.indexOfFirst { it.route == destination }} ?: 0
        }
    }

    DisposableEffect(Unit) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            currentDestination = destination.route
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    Column(
        modifier = Modifier.padding(SafeAreaPadding)
    ) {
        TopBar(
            selectedTabIndex = currentTopBarSelectedTabIndex
        ) { screen ->
            navController.navigate(screen.route) {
                if (screen == TopBarTabs[0]) popUpTo(TopBarTabs[0].route)
                launchSingleTop = true
            }
        }

        Body(navController = navController)
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    screens: List<Screens> = TopBarTabs,
    onScreenSelection: (screen: Screens) -> Unit
) {
    val focusManager = LocalFocusManager.current

    Row {
        PixploreLogo(modifier = Modifier.width(100.dp))
        Spacer(modifier = Modifier.width(58.dp))
        TabRow(
            modifier = modifier
                .padding(bottom = 16.dp),
            selectedTabIndex = selectedTabIndex
        ) {
            screens.forEachIndexed { index, screen ->
                key(index) {
                    Tab(
                        selected = index == selectedTabIndex,
                        onFocus = { onScreenSelection(screen) },
                        onClick = { focusManager.moveFocus(FocusDirection.Down) }
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
    }
}

@Composable
private fun Body(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(
            Screens.Home.route
        ) {
            HomeScreen()
        }
        composable(
            Screens.Search.route
        ) {
            SearchScreen()
        }
        composable(
            Screens.About.route
        ) {
            AboutScreen()
        }
    }
}