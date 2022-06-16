package com.example.movieapp_jetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_jetpackcompose.utils.NavRoutes

@Composable
fun NavHostController(navController: NavHostController) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.SplashScreen.routes) {

        composable(NavRoutes.SplashScreen.routes) {
            SplashScreenView(navController)
        }

        composable(NavRoutes.MainActivity.routes) {
            HomeComponent(navController = navController)
        }

    }

}