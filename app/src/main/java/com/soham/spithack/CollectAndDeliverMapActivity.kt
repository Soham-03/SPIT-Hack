package com.soham.spithack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.soham.spithack.screens.CollectAndDeliverMapScreen
import com.soham.spithack.screens.ui.theme.SPITHackTheme

class CollectAndDeliverMapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SPITHackTheme {
                CollectAndDeliverMapScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    SPITHackTheme {
//        Greeting2("Android")
        CollectAndDeliverMapScreen()
    }
}