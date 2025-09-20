package com.satish.graphqldemo.data

import com.satish.graphqldemo.AnimeMediaListQuery
import com.satish.graphqldemo.domain.AnimeMedia

fun AnimeMediaListQuery.Medium.toAnimeMedia(): AnimeMedia {
    return AnimeMedia(
        title = this.title?.userPreferred ?: "",
        genres = this.genres?.joinToString(",") ?: "",
        type = (this.type ?: "").toString(),
        coverImage = this.coverImage?.medium ?: "",
        episodes = this.episodes ?: 0
    )
}