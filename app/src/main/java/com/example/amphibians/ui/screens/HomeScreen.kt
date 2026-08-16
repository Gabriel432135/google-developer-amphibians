package com.example.amphibians.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier




@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

}

@Composable
fun CardAmphibian(modifier: Modifier = Modifier, title: String, description: String, imageSrc: String) {
    Text(title)
}


@Composable
fun HomeScreenPreview(name: String, modifier: Modifier = Modifier) {
    HomeScreen( )
}