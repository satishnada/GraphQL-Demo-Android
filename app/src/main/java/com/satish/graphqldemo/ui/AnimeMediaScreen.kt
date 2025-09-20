package com.satish.graphqldemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.satish.graphqldemo.domain.AnimeMedia
import com.satish.graphqldemo.presentation.AnimeViewModel

@Composable
fun AnimeMediaScreen(modifier: Modifier = Modifier, state: AnimeViewModel.UiState) {
    Box(modifier = modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.animeList) { anime ->
                    AnimeItem(anime = anime,
                        modifier = Modifier.fillMaxSize()
                            .padding(16.dp))
                }
            }
        }
    }
}

@Composable
private fun AnimeItem(
    anime: AnimeMedia,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Row {
            AsyncImage(
                model = anime.coverImage,
                contentDescription = "Anime Image",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = anime.title,
                    fontSize = 22.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(26.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Genres Icon",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = anime.genres,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(26.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Anime Type Icon",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = anime.type,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 8.dp),
            color = Color.LightGray
        )
    }
}


@Preview(showBackground = false)
@Composable
fun AnimeItemPreview() {
    AnimeItem(
        anime = AnimeMedia(
            title = "Attack on Titan",
            coverImage = "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx16498-C6FPmWm59CyP.jpg",
            genres = "Action, Drama, Fantasy",
            type = "TV",
            episodes = 25
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}
