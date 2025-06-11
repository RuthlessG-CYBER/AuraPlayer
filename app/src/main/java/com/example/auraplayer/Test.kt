package com.example.auraplayer

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


data class Song(val title: String, val resId: Int)

@Composable
fun AudioPlayer(context: Context) {
//    val songList = listOf(
//        Song("Song 1", R.raw.shape_of_you),
//        Song("Song 2", R.raw.bohemian_rhapsody),
//        Song("Song 3", R.raw.lose_yourself),
//        Song("Song 4", R.raw.take_five),
//        Song("Song 5", R.raw.blinding_lights),
//        Song("Song 6", R.raw.hotel_california),
//        Song("Song 7", R.raw.perfect),
//        Song("Song 8", R.raw.imagine),
//        Song("Song 9", R.raw.smooth),
//        Song("Song 10", R.raw.hotel_california)
//    )

    var currentSongIndex by remember { mutableStateOf(0) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }

    fun playSong(index: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, musicDataList[index].songResId)
        mediaPlayer?.start()
    }

    fun pauseSong() {
        mediaPlayer?.pause()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard {
            Icon(
                Icons.Default.MusicNote, contentDescription = "Music Icon",
                modifier = Modifier.size(100.dp),
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Text(musicDataList[currentSongIndex].musicName, color = Color.White)

        Spacer(modifier = Modifier.size(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Icon(
                Icons.Default.PlayArrow, contentDescription = "Play",
                modifier = Modifier.size(30.dp).clickable { playSong(currentSongIndex) },
                tint = Color.White
            )
            Icon(
                Icons.Default.Pause, contentDescription = "Pause",
                modifier = Modifier.size(30.dp).clickable { pauseSong() },
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        // Song selector
        LazyColumn {
            itemsIndexed(musicDataList) { index, song ->
                Text(
                    text = song.musicName,
                    color = if (index == currentSongIndex) Color.Green else Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            currentSongIndex = index
                            playSong(index)
                        }
                        .padding(10.dp)
                )
            }
        }
    }
}
