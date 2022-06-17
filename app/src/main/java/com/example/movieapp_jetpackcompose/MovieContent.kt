package com.example.movieapp_jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_jetpackcompose.ui.theme.BackgroundColor
import com.example.movieapp_jetpackcompose.ui.theme.BackgroundColorLight
import com.example.movieapp_jetpackcompose.ui.theme.Poppins
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle


@Composable
fun MovieContent(navController: NavController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = BackgroundColor
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            MovieHeaderSection(navController)
            Spacer(modifier = Modifier.height(10.dp))
            MoviePreviewSection()
            Spacer(modifier = Modifier.height(10.dp))
            MovieTextSection()
        }
    }

}


@Composable
fun MovieTextSection() {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = "Maleficent",
            style = TextStyle(
                fontFamily = Poppins,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        Text(
            text = "Mistress of Evil",
            style = TextStyle(
                fontFamily = Poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        )



        RatingBar(
            value = 4.8F,
            config = RatingBarConfig().style(RatingBarStyle.HighLighted),
            onValueChange  = {

            },
            onRatingChanged = {

            },
            modifier = Modifier.padding(10.dp)
        )



        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = "Director : Alex Tina ",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )


            Icon(
                painter = painterResource(id = R.drawable.ic_space),
                contentDescription = "Space",
                tint = Color.White
            )


            Text(
                text = " 4.8 ",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .height(45.dp)
                    .width(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(20.dp)),
                backgroundColor = BackgroundColorLight,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Crime", style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontFamily = Poppins,
                            fontSize = 14.sp
                        )
                    )
                }
            }


            Card(
                modifier = Modifier
                    .height(45.dp)
                    .width(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(20.dp)),
                backgroundColor = BackgroundColorLight,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Drama", style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontFamily = Poppins,
                            fontSize = 14.sp
                        )
                    )
                }
            }


        }



        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp)),
            backgroundColor = BackgroundColorLight
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "Buy Ticket",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }


    }


}


@Composable
fun MovieHeaderSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Icon Back",
            modifier = Modifier
                .size(64.dp)
                .padding(10.dp)
                .clickable {
                    navController.navigate(NavRoutes.MainScreen.routes)
                },
            tint = Color.White,
        )


        Text(
            text = "Detail Movie", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                fontFamily = Poppins,
                textAlign = TextAlign.Center
            )
        )

        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "Icon Back",
            modifier = Modifier
                .size(64.dp)
                .padding(10.dp)
                .alpha(0f),

            )


    }
}


@Composable
fun MoviePreviewSection() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(60.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.imag2),
            contentDescription = "Movie Image",
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview(
    showBackground = true
)
@Composable
fun MovieContentPreview() {
    MovieContent(navController = rememberNavController())
}
