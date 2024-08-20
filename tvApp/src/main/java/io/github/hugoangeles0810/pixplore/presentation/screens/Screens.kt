package io.github.hugoangeles0810.pixplore.presentation.screens

import androidx.annotation.StringRes
import io.github.hugoangeles0810.pixplore.R

enum class Screens(
    @StringRes
    val title: Int
) {
    Home(R.string.home_screen_name),
    Search(R.string.search_screen_name),
    About(R.string.about_screen_name)
}