package com.example.auraplayer

import androidx.compose.ui.graphics.vector.ImageVector

data class Data(
    val text: String
)

val chipsDataList = listOf(
    Data("Trending right now"),
    Data("Rock"),
    Data("Pop"),
    Data("Hip Hop"),
    Data("Indie"),
    Data("Electronic")
)

data class musicData(
    val musicName: String,
    val artistName: String,
    val image: Int
)
val musicDataList = listOf(
    musicData("Song Name 1", "Artist Name 1", R.drawable.trending1),
    musicData("Song Name 2", "Artist Name 2", R.drawable.trending2),
    musicData("Song Name 3", "Artist Name 3", R.drawable.trending3),
    musicData("Song Name 4", "Artist Name 4", R.drawable.trending4),
    musicData("Song Name 5", "Artist Name 5", R.drawable.trending5),
    musicData("Song Name 6", "Artist Name 6", R.drawable.trending1)
)