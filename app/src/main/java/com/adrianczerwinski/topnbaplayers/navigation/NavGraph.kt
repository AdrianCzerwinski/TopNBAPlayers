package com.adrianczerwinski.topnbaplayers.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.adrianczerwinski.topnbaplayers.presentation.screens.details.DetailsScreen
import com.adrianczerwinski.topnbaplayers.presentation.screens.home.HomeScreen
import com.adrianczerwinski.topnbaplayers.presentation.screens.search.SearchScreen
import com.adrianczerwinski.topnbaplayers.presentation.screens.splash.SplashScreen
import com.adrianczerwinski.topnbaplayers.presentation.screens.welcome.WelcomeScreen
import com.adrianczerwinski.topnbaplayers.util.Constants.DETAILS_ARGUMENT_ID
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavController){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_ID) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}