package com.example.auraplayer

import androidx.compose.ui.graphics.vector.ImageVector

data class Data(
    val text: String
)

val chipsDataList = listOf(
    Data("All"),
    Data("Trending right now"),
    Data("Rock"),
    Data("Pop"),
    Data("Hip Hop"),
    Data("Indie"),
    Data("Electronic"),
    Data("Jazz")
)

data class musicData(
    val musicName: String,
    val artistName: String,
    val image: Int,
    val category: String,
    val songResId: Int
)
val musicDataList = listOf(
    musicData("Shape of You", "Ed Sheeran", R.drawable.trending1, "Trending right now", R.raw.shape_of_you),
    musicData("Bohemian Rhapsody", "Queen", R.drawable.trending2, "Rock", R.raw.bohemian_rhapsody),
    musicData("Lose Yourself", "Eminem", R.drawable.trending3, "Hip-Hop", R.raw.lose_yourself),
    musicData("Take Five", "Dave Brubeck", R.drawable.trending4, "Jazz", R.raw.take_five),
    musicData("Blinding Lights", "The Weeknd", R.drawable.trending5, "Trending right now", R.raw.blinding_lights),
    musicData("Hotel California", "Eagles", R.drawable.trending3, "Rock", R.raw.hotel_california),
    musicData("Perfect", "Ed Sheeran", R.drawable.trending1, "Trending right now", R.raw.perfect),
    musicData("Imagine", "John Lennon", R.drawable.trending2, "Rock", R.raw.imagine),
    musicData("Smooth", "Santana", R.drawable.trending4, "Pop", R.raw.smooth),
    musicData("Hotel California", "Eagles", R.drawable.trending5, "Rock", R.raw.hotel_california)
)