package com.example.movieapp_jetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_jetpackcompose.ui.theme.BackgroundColor
import com.example.movieapp_jetpackcompose.ui.theme.Poppins
import com.example.movieapp_jetpackcompose.utils.NavRoutes


@Composable
fun SplashScreenView(navController: NavController) {


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = BackgroundColor
    ) {
        SplashContent(navController)
    }
}


@Composable
fun SplashContent(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        ButtonNext(navController)
    }

}


@Composable
fun ButtonNext(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.End
    ) {
        Card(
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(24.dp))
                .clickable {
                    navController.navigate(NavRoutes.MainActivity.routes)
                },
            backgroundColor = Color(0xFF161A37),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Start",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

    }
}

@Preview(
    showBackground = true
)
@Composable
fun showSplash() {
    SplashScreenView(navController = rememberNavController())
}

