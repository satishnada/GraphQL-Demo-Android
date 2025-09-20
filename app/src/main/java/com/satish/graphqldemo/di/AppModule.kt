package com.satish.graphqldemo.di

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.satish.graphqldemo.data.ApolloAnimeClient
import com.satish.graphqldemo.domain.AnimeClient
import com.satish.graphqldemo.domain.GetAnimeMediaUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(app: Application): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://graphql.anilist.co")
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimeClient(apolloClient: ApolloClient): AnimeClient {
        return ApolloAnimeClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetAnimeUseCase(animeClient: AnimeClient): GetAnimeMediaUseCase {
        return GetAnimeMediaUseCase(animeClient)
    }
}