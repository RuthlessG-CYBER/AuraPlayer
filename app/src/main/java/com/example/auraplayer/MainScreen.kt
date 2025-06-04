package com.example.auraplayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreenUI(){
    Box(modifier = Modifier.fillMaxSize()
        .background(
            color = Color(0xFF5c5f5c).copy(alpha = 1f)
        )
    ){
        Column(modifier = Modifier.fillMaxSize()
            .systemBarsPadding()
            .padding(top = 10.dp)){

            // Top Bar with Menu and Search Bar
            Row(modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)){
                Card(
                    onClick = {},
                    modifier = Modifier.size(56.dp).align(Alignment.CenterVertically),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ){
                        Icon(
                            Icons.Default.Menu, contentDescription = "Menu",
                            modifier = Modifier.size(35.dp).align(Alignment.Center),
                            tint = Color.LightGray
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                var search by remember { mutableStateOf("") }
                TextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = { Text(text = "Search") },
                    modifier = Modifier.height(56.dp).fillMaxWidth().align(Alignment.CenterVertically),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Gray,
                        focusedContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    )
                )
            }

            // For Giving Space between Top Bar and Text
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Trending Right Now",
                color = Color.White,
                fontSize = 25.sp,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )

            // For Giving Space between Text and Songs
            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Spacer(modifier = Modifier.width(10.dp))
                repeat(5){
                    Card(modifier = Modifier.size(250.dp, 180.dp),
                        shape = RoundedCornerShape(30.dp),
                    ){
                        Box(modifier = Modifier.fillMaxSize()
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.trending1),
                                contentDescription = "Image",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Icon(
                                Icons.Default.MoreHoriz, contentDescription = "More",
                                modifier = Modifier.align(Alignment.TopEnd)
                                    .padding(top = 10.dp, end = 20.dp),
                                tint = Color.White
                            )
                            Card(modifier = Modifier
                                .height(70.dp)
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Gray.copy(alpha = .5f)
                                ),
                                shape = RoundedCornerShape(bottomStart = 30.dp,
                                    bottomEnd = 30.dp,
                                    topStart = 20.dp,
                                    topEnd = 20.dp),
                            ){
                                Box(modifier = Modifier.fillMaxSize()
                                    .padding(10.dp)
                                ){
                                    Row(modifier = Modifier.fillMaxSize()){
                                        Column(modifier = Modifier.align(Alignment.CenterVertically)){
                                            Text(
                                                text = "Song Name",
                                                color = Color.White,
                                                modifier = Modifier.padding(start = 10.dp)
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "Artist Name",
                                                color = Color.LightGray,
                                                modifier = Modifier.padding(start = 10.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        IconButton(onClick = {},
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            colors = IconButtonDefaults.iconButtonColors(
                                                containerColor = Color.White
                                            )) {
                                            Icon(
                                                Icons.Default.PlayArrow, contentDescription = "Play",
                                                tint = Color.Black
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Categories Chips
            var clicked by remember { mutableStateOf(-1) }

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                chipsDataList.forEachIndexed { index, chip ->
                    OutlinedCard(
                        modifier = Modifier
                            .clickable { clicked = index },
                        colors = CardDefaults.cardColors(
                            containerColor = if (clicked == index) Color.White.copy(alpha = .5f) else Color.Transparent
                        )
                    ) {
                        Text(
                            text = chip.text,
                            color = if (clicked == index) Color.Black else Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Music according to chip
            Column(modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(5.dp)
                ){
                musicDataList.forEach {
                    Card(onClick = {},
                        modifier = Modifier.height(80.dp).fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                        ){
                        Row(modifier = Modifier.fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp)
                        ){
                            Card(modifier = Modifier.size(70.dp).align(Alignment.CenterVertically)){
                                Image(
                                    painter = painterResource(id = it.image),
                                    contentDescription = "Image",
                                    modifier = Modifier.size(70.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Column(modifier = Modifier.align(Alignment.CenterVertically)){
                                Text(text = it.musicName,
                                    color = Color.White,
                                    fontSize = 18.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text = it.artistName,
                                    color = Color.White,
                                    fontSize = 15.sp
                                    )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                Icons.Default.FavoriteBorder, contentDescription = "Like",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
        }
        var clicked by remember { mutableStateOf(-1) }

        ElevatedCard(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                .align(Alignment.BottomCenter),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 40.dp, end = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = if (clicked == 0) Color.Gray else Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(30.dp)
                        .clickable { clicked = 0 }
                )
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    tint = if (clicked == 1) Color.Gray else Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(30.dp)
                        .clickable { clicked = 1 }
                )
                Icon(
                    Icons.Default.MusicNote,
                    contentDescription = "Music",
                    tint = if (clicked == 2) Color.Gray else Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(30.dp)
                        .clickable { clicked = 2 }
                )
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = if (clicked == 3) Color.Gray else Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(30.dp)
                        .clickable { clicked = 3 }
                )
            }
        }

    }
}