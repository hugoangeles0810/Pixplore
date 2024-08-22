package io.github.hugoangeles0810.pixplore.presentation.components

import android.view.KeyEvent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import io.github.hugoangeles0810.pixplore.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    val textFieldFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val textFieldInteractionSource = remember { MutableInteractionSource() }
    val isTfFocused by textFieldInteractionSource.collectIsFocusedAsState()

    Surface(
        shape = ClickableSurfaceDefaults.shape(shape = ShapeDefaults.ExtraSmall),
        scale = ClickableSurfaceDefaults.scale(focusedScale = 1f),
        colors = ClickableSurfaceDefaults.colors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
            pressedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
            focusedContentColor = MaterialTheme.colorScheme.onSurface,
            pressedContentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = ClickableSurfaceDefaults.border(
            focusedBorder = Border(
                border = BorderStroke(
                    width = if (isTfFocused) 2.dp else 1.dp,
                    color = animateColorAsState(
                        targetValue = if (isTfFocused) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.border,
                        label = ""
                    ).value
                ),
                shape = ShapeDefaults.ExtraSmall
            )
        ),
        tonalElevation = 2.dp,
        onClick = { textFieldFocusRequester.requestFocus() },
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp)
    ) {
        BasicTextField(
            value = searchQuery,
            onValueChange = onValueChange,
            decorationBox = {
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .padding(start = 20.dp),
                ) {
                    it()
                    if (searchQuery.isEmpty()) {
                        Text(
                            modifier = Modifier.graphicsLayer { alpha = 0.6f },
                            text = stringResource(R.string.search_screen_et_placeholder),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .focusRequester(textFieldFocusRequester)
                .dpadFocusSupport(focusManager),
            cursorBrush = Brush.verticalGradient(
                colors = listOf(
                    LocalContentColor.current,
                    LocalContentColor.current
                )
            ),
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(searchQuery)
                }
            ),
            maxLines = 1,
            interactionSource = textFieldInteractionSource,
            textStyle = MaterialTheme.typography.titleSmall.copy(
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.dpadFocusSupport(focusManager: FocusManager) = this.onKeyEvent {
    if (it.nativeKeyEvent.action == KeyEvent.ACTION_UP) {
        when (it.nativeKeyEvent.keyCode) {
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                focusManager.moveFocus(FocusDirection.Down)
            }

            KeyEvent.KEYCODE_DPAD_UP -> {
                focusManager.moveFocus(FocusDirection.Up)
            }

            KeyEvent.KEYCODE_BACK -> {
                focusManager.moveFocus(FocusDirection.Exit)
            }
        }
    }
    true
}