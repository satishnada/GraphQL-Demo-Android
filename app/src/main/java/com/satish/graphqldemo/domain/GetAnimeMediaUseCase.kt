package com.satish.graphqldemo.domain

class GetAnimeMediaUseCase(
    private val animeClient: AnimeClient
) {
    suspend fun execute() : List<AnimeMedia> {
        return animeClient.getAnimeList()
            .sortedBy { it.title }
    }
}