package com.example.wearoscomposelearning.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.wearoscomposelearning.presentation.screens.ScalingLazyColumnScreen
import com.example.wearoscomposelearning.presentation.screens.ToggleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // WelcomeScreen("Android")
            // ButtonsScreen()
            // ChipScreen()
            // ToggleScreen()
            ScalingLazyColumnScreen()
        }
    }
}



@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    // WelcomeScreen("Preview Android")
    // ButtonsScreen()
    // ChipScreen()
    // ToggleScreen()
    ScalingLazyColumnScreen()
}