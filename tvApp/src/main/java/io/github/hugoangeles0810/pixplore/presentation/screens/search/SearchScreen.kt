package io.github.hugoangeles0810.pixplore.presentation.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.github.hugoangeles0810.pixplore.presentation.components.SearchBar

@Composable
fun SearchScreen() {

    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            searchQuery = searchQuery,
            onValueChange = { newQuery -> searchQuery = newQuery },
            onSearch = { term ->

            }
        )
        Box(modifier = Modifier.fillMaxSize()) {

        }
    }
}