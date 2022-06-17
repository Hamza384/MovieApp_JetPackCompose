package com.example.movieapp_jetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SetUpNavGraph(navController: NavController) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.SplashScreen.routes) {

        composable(NavRoutes.SplashScreen.routes) {
            SplashScreenView(navController = navController)
        }

        composable(NavRoutes.MainScreen.routes) {
            HomeComponent(navController = navController)
        }

        composable(NavRoutes.DetailScreen.routes) {
            MovieContent(navController = navController)
        }

    }

}