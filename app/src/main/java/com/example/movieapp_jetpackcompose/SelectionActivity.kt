package com.example.movieapp_jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_jetpackcompose.model.CategoriesModel
import com.example.movieapp_jetpackcompose.model.MovieModel
import com.example.movieapp_jetpackcompose.ui.theme.BackgroundColor
import com.example.movieapp_jetpackcompose.ui.theme.Poppins
import com.example.movieapp_jetpackcompose.utils.Constants


@Composable
fun HomeComponent(navController: NavController) {
    return Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = BackgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(10.dp))
            CategoriesSection()
            Spacer(modifier = Modifier.height(10.dp))
            CategoriesList()
            Spacer(modifier = Modifier.height(10.dp))
            PopularMovies()
            Spacer(modifier = Modifier.height(10.dp))
            MoviesLists()
        }
    }

}


@Composable
fun HeaderSection() {
    val mContext = LocalContext.current
    return Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hi, Hamza!",
            style = TextStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            ),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "Profile",
            modifier = Modifier.clickable {
                Constants.showToast(mContext, "Profile")
            }
        )
    }
}


@Composable
fun SearchViewSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {

    }

}


@Composable
fun CategoriesSection() {
    return Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Categories", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center
        )

        Text(
            text = "See more", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            ),
            textAlign = TextAlign.Center
        )

    }

}


@Composable
fun CategoriesList() {
    val modelList = mutableListOf<CategoriesModel>()
    modelList.add(CategoriesModel(R.drawable.emoji1, "Comedy"))
    modelList.add(CategoriesModel(R.drawable.emoji2, "Horror"))
    modelList.add(CategoriesModel(R.drawable.emoji3, "Romance"))
    modelList.add(CategoriesModel(R.drawable.emoji4, "Drama"))
    modelList.add(CategoriesModel(R.drawable.emoji5, "Love"))
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(modelList) {
            CategoryListRow(categoryModel = it)
        }
    }

}


@Composable
fun MoviesLists() {

    val movieList = mutableListOf<MovieModel>()
    movieList.add(MovieModel(R.drawable.la_casa, "La Case", 2))
    movieList.add(MovieModel(R.drawable.image1, "Inception", 2))
    movieList.add(MovieModel(R.drawable.imag2, "Maleficent", 2))
    movieList.add(MovieModel(R.drawable.image3, "BloodShot", 2))
    movieList.add(MovieModel(R.drawable.image4, "Veloziz, Furious", 2))


    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(movieList) {
            PopularMoviesList(movieModel = it)
        }
    }


}


@Composable
fun CategoryListRow(categoryModel: CategoriesModel) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {

            },
        backgroundColor = Color(0xFF161A37)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryModel.image),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
            Text(
                text = categoryModel.text,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = Poppins
                )
            )
        }
    }

}


@Composable
fun PopularMoviesList(movieModel: MovieModel) {

    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(180.dp)
                .height(200.dp)
                .padding(6.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
            Image(
                painter = painterResource(id = movieModel.image),
                contentDescription = "Movie Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        Constants.showToast(
                            mContext,
                            movieModel.name
                        )
                    }
            )
        }

        Text(
            text = movieModel.name,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                fontFamily = Poppins
            ),
            textAlign = TextAlign.Center
        )

    }

}


@Composable
fun PopularMovies() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Popular Movies", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        )

        Text(
            text = "See more", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        )
    }
}


@Preview(
    showBackground = true
)
@Composable
fun ShowMainScreen() {
    HomeComponent(navController = rememberNavController())
}