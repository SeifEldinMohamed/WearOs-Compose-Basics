package com.example.wearoscomposelearning.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.example.wearoscomposelearning.presentation.theme.WearOSComposeLearningTheme

/**
 * Because a round device is smaller at the top and bottom,
 * there is less space to show items. Therefore, Wear OS has its own
 * version of LazyColumn to better support those round devices.

 * ScalingLazyColumn extends LazyColumn to support both scaling and
 * transparency at the top and bottom of the screen to make the content
 * more readable to the user.
 *
 * ScalingLazyColumn already provides default settings that guarantee a better default
 * visual effect as most of the viewport will be filled with list items. In many cases
 * default parameters will be sufficient, if you have header on top we recommend
 * putting it into ListHeader as a first item. Otherwise, consider setting autoCentering
 * with the itemIndex as 0 that will provide sufficient padding for the first item.
 **/

@Composable
fun ScalingLazyColumnScreen() {
    WearOSComposeLearningTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            val listState = rememberScalingLazyListState()

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = listState
            ) {
                item { ButtonsScreen() }
                item { WelcomeScreen("Hello Android") }
                item { ChipScreen()}
                item { ToggleScreen() }
            }
        }
    }
}

/**
 * Scaffold provides a layout structure to help you arrange screens in common
 * patterns, just like mobile, but instead of an App Bar, FAB, Drawer,
 * or other mobile specific elements, it supports four Wear specific layouts
 * with top-level components: time, vignette, scroll/position indicator and
 * the page indicator.

 * It also handles both round and non-round devices.
 **/