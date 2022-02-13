package com.adrianczerwinski.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adrianczerwinski.borutoapp.util.Constants.DETAILS_ARGUMENT_ID

@Composable
fun SetupNavGraph(navController: NavController){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Welcome.route) {

        }
        composable(route = Screen.Home.route) {

        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_ID) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.SearchScreen.route) {

        }
    }
}