package com.mealsdatabase.samplemutliplescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mealsdatabase.samplemutliplescreen.ui.theme.SampleMutlipleScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleMutlipleScreenTheme {
                MainAppBar()
            }
        }
    }
}

