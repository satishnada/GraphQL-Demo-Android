package com.satish.graphqldemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satish.graphqldemo.domain.AnimeMedia
import com.satish.graphqldemo.domain.GetAnimeMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimeMediaUseCase: GetAnimeMediaUseCase
): ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val usState = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update { it.copy(
                animeList = getAnimeMediaUseCase.execute(),
                isLoading = false
            ) }
        }
    }

    fun selectAnime(anime: AnimeMedia) {
        viewModelScope.launch {
            _state.update { it.copy(selectedAnime = anime) }
        }
    }

    data class UiState(
        val animeList: List<AnimeMedia> = emptyList(),
        val selectedAnime: AnimeMedia? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )
}