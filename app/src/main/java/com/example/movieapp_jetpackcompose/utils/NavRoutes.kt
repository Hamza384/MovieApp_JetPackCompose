package com.example.movieapp_jetpackcompose.utils

sealed class NavRoutes (val routes : String) {

    object SplashScreen :  NavRoutes("splash")
    object MainActivity :  NavRoutes("main")

}
