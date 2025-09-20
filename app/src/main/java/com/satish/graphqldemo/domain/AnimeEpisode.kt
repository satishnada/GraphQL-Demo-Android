package com.satish.graphqldemo.domain

data class AnimeEpisode(
    val title: String,
    val genres: List<String>,
    val type: String,
    val coverImage: String,
    val episodes: Int
)
