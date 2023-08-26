package com.mosayed.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mosayed.myapplication.presentation.screen_aya.AyaScreen
import com.mosayed.myapplication.presentation.screen_sura.SuraScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.Sura.route){
        composable(route = Screen.Sura.route){
            SuraScreen(navHostController)
        }

        composable(route = Screen.Aya.route){
            AyaScreen(navHostController)
        }
    }
}

sealed class Screen(val route: String) {
    data object Sura : Screen("sura_screen")
    data object Aya : Screen("aya_screen")
}