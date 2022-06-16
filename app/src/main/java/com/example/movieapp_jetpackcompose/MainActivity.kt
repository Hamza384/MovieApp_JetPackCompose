package com.example.movieapp_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_jetpackcompose.ui.theme.MovieApp_JetPackComposeTheme


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp_JetPackComposeTheme {
                navController = rememberNavController()
                NavHostController(navController = navController)
            }
        }
    }
}


