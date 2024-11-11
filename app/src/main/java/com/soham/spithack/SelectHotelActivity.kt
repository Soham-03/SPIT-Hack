package com.soham.spithack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.util.DebugLogger
import com.soham.spithack.screens.SelectHotelScreen
import com.soham.spithack.ui.theme.SPITHackTheme

class SelectHotelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SPITHackTheme {
                SelectHotelScreen(Global.donor)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SPITHackTheme {
//        SelectHotelScreen()
    }
}