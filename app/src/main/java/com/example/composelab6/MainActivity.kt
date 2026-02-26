package com.example.composelab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import com.example.composelab6.ui.theme.ComposeLab6Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLab6Theme {
                Scaffold {
                    innerPadding -> AppNavigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

        }
    }
}




