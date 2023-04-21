package com.example.wearoscomposelearning.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            Scaffold(
                timeText = {
                    TimeText(modifier = Modifier.scrollAway(listState))
                },
                vignette = {
                    // Only show a Vignette for scrollable screens. This app only has one screen,
                    // which is scrollable, so we show it all the time.
                    Vignette(vignettePosition = VignettePosition.TopAndBottom)
                },
                positionIndicator = {
                    PositionIndicator(
                        scalingLazyListState = listState
                    )
                }
            ) {

                ScalingLazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    autoCentering = AutoCenteringParams(itemIndex = 0),
                    state = listState
                ) {
                    item { ButtonsScreen() }
                    item { WelcomeScreen("Hello Android") }
                    item { ChipScreen() }
                    item { ToggleScreen() }
                }
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
 *
 * TimeText uses curved text under the hood and gives developers an easy way
 * to show the time without placing the composable or having to do
 * any work with time related classes.
 * The Material Guidelines require that you display the time
 * at the top of any screen within the app.

 * A Vignette blurs the top and bottom edges of the wearable screen when
 * a screen capable of scrolling is displayed.
 * Developers can specify to blur the top, bottom, or both depending
 * on the use case.

 * The PositionIndicator (also known as the Scrolling Indicator) is an indicator
 * on the right side of the screen to show the current indicator
 * location based on the type of state object you pass in.
 * In our case, that will be the ScalingLazyListState.
 *
 * You might wonder why the position indicator needs to be up
 * at the Scaffold level and not the ScalingLazyColumn level.

 * Well, due to the curvature of the screen,
 * the position indicator needs to be centered on the watch
 * (Scaffold), not just centered on the viewport (ScalingLazyColumn).
 * Otherwise, it could be cut off.
 *
 * It also has a nice feature where
 * it hides itself when the user isn't scrolling.
 * We're using the ScalingLazyListState but PositionIndicator takes
 * many other scrolling options, e.g., ScrollState, LazyListState,
 * and even can handle the rotating side button or the rotating bezel.
 **/