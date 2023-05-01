package com.example.wearoscomposelearning.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import com.example.wearoscomposelearning.presentation.theme.WearOSComposeLearningTheme

@Composable
fun ToggleScreen() {
    WearOSComposeLearningTheme {
        // Modifiers used by our Wear composables.
        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)

        MyToggleChip(contentModifier)
    }

}

@Composable
fun MyToggleChip(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToggleChip(
            modifier = modifier,
            checked = checked,
            toggleControl = {
                Switch(
                    checked = checked,
                    modifier = Modifier.semantics {
                        this.contentDescription = if (checked) "On" else "Off"
                    }
                )
            },
            onCheckedChange = {
                checked = it
            },
            label = {
                Text(
                    text = "Sound",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        )
    }
}