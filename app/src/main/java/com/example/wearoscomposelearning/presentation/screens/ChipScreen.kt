package com.example.wearoscomposelearning.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SelfImprovement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.wearoscomposelearning.presentation.theme.WearOSComposeLearningTheme


@Composable
fun ChipScreen() {
    WearOSComposeLearningTheme {
        // Modifiers used by our Wear composables.
        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
        val iconModifier = Modifier
            .size(24.dp)
            .wrapContentSize(align = Alignment.Center)

        Chip(contentModifier, iconModifier)
    }

}

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Chip(
            modifier = modifier,
            onClick = { /* ... */ },
            label = {
                Text(
                    text = "5 minute Meditation",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.SelfImprovement,
                    contentDescription = "triggers meditation action",
                    modifier = iconModifier
                )
            },
        )
    }
}