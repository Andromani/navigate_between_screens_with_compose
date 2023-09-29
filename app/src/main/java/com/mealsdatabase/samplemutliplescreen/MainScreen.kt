package com.mealsdatabase.samplemutliplescreen

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mealsdatabase.samplemutliplescreen.ui.theme.CommonUi
import com.mealsdatabase.samplemutliplescreen.ui.theme.ScreenMain

enum class MainScreen(@StringRes val screenName: Int) {
    Screen(screenName = R.string.screen_main),
    Screen1(screenName = R.string.screen_one),
    Screen2(screenName = R.string.screen_two),
    Screen3(screenName = R.string.screen_three),
    Screen4(screenName = R.string.screen_four),
    Screen5(screenName = R.string.screen_five)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    currentScreen: MainScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    MediumTopAppBar(title = { Text(stringResource(currentScreen.screenName)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.White),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button"
                    )
                }
            }
        }
    )
}

@Composable
fun MainAppBar(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreenName =
        MainScreen.valueOf(backStackEntry?.destination?.route ?: MainScreen.Screen.name)
    Scaffold(topBar = {
        MainAppBar(currentScreen = currentScreenName,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreen.Screen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Screen.name) {
                ScreenMain(
                    onScreenOneButtonClicked = {
                        navController.navigate(MainScreen.Screen1.name)
                    },
                    onScreenTwoButtonClicked = {
                        navController.navigate(MainScreen.Screen2.name)
                    }, onScreenThreeButtonClicked = {
                        navController.navigate(MainScreen.Screen3.name)
                    }, onScreenFourButtonClicked = {
                        navController.navigate(MainScreen.Screen4.name)
                    }
                ) {
                    navController.navigate(MainScreen.Screen5.name)
                }
            }
            composable(route = MainScreen.Screen1.name) {
                CommonUi(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                )
            }
            composable(route = MainScreen.Screen2.name) {
                CommonUi(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue)
                )
            }
            composable(route = MainScreen.Screen3.name) {
                CommonUi(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Yellow)
                )
            }
            composable(route = MainScreen.Screen4.name) {
                CommonUi(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                )
            }
            composable(route = MainScreen.Screen5.name) {
                CommonUi(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Magenta)
                )
            }
        }
    }
}