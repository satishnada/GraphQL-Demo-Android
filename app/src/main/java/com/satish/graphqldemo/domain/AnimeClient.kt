package com.satish.graphqldemo.domain

interface AnimeClient {
    suspend fun getAnimeList(): List<AnimeMedia>
    suspend fun getAnimeEpisode(): List<AnimeEpisode>
}