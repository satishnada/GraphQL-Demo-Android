package com.satish.graphqldemo.data

import com.apollographql.apollo.ApolloClient
import com.satish.graphqldemo.AnimeMediaListQuery
import com.satish.graphqldemo.domain.AnimeClient
import com.satish.graphqldemo.domain.AnimeEpisode
import com.satish.graphqldemo.domain.AnimeMedia

class ApolloAnimeClient(private val apolloClient: ApolloClient) : AnimeClient {
    override suspend fun getAnimeList(): List<AnimeMedia> {
        return apolloClient
            .query(AnimeMediaListQuery())
            .execute()
            .data
            ?.Page
            ?.media
            ?.map { media ->
                media?.toAnimeMedia() as AnimeMedia
            } ?: emptyList()
    }

    override suspend fun getAnimeEpisode(): List<AnimeEpisode> {
        return emptyList()
    }

}