package com.satish.graphqldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.satish.graphqldemo.domain.AnimeMedia
import com.satish.graphqldemo.presentation.AnimeViewModel
import com.satish.graphqldemo.ui.AnimeMediaScreen
import com.satish.graphqldemo.ui.theme.GraphQLDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraphQLDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Anime Media") }
                        )
                    }
                ) { padding ->
                    val viewModel = hiltViewModel<AnimeViewModel>()
                    val state = viewModel.usState.collectAsState()
                    AnimeMediaScreen(modifier = Modifier.padding(padding), state = state.value)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GraphQLDemoTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text("Anime Media") })
            }
        ) { padding ->
            AnimeMediaScreen(
                modifier = Modifier.padding(padding),
                state = AnimeViewModel.UiState(
                    animeList = listOf(
                        AnimeMedia(
                            "Naruto",
                            "Naruto",
                            "Action",
                            "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx20-YJvLbgJQPCoI.jpg",
                            episodes = 0
                        ),
                        AnimeMedia(
                            "Naruto",
                            "One Piece",
                            "Adventure",
                            "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx21-YCDoj1EkAxFn.jpg",
                            0
                        )
                    )
                )
            )
        }
    }
}