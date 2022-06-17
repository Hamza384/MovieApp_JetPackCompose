package com.example.movieapp_jetpackcompose

sealed class NavRoutes(val routes: String) {
    object SplashScreen : NavRoutes("splash")
    object MainScreen : NavRoutes("main")
    object DetailScreen : NavRoutes("detail")
}
