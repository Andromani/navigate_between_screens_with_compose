package com.mealsdatabase.samplemutliplescreen.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mealsdatabase.samplemutliplescreen.R

@Composable
fun ScreenMain(
    onScreenOneButtonClicked: () -> Unit,
    onScreenTwoButtonClicked: () -> Unit,
    onScreenThreeButtonClicked: () -> Unit,
    onScreenFourButtonClicked: () -> Unit,
    onScreenFiveButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Button(
            onClick = onScreenOneButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.screen_one))
        }

        Button(
            onClick = onScreenTwoButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.screen_two))
        }
        Button(
            onClick = onScreenThreeButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.screen_three))
        }

        Button(
            onClick = onScreenFourButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.screen_four))
        }

        Button(
            onClick = onScreenFiveButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.screen_five))
        }
    }
}

