package com.example.musicapp.ui.states

import com.example.musicapp.models.Collector

data class CollectorListUiState(
    val collectors: List<Collector> = emptyList()
)