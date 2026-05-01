package com.example.musicapp.ui.states

import com.example.musicapp.models.Collector

data class CollectorDetailUiState(
    val collector: Collector = Collector(0, "", "", "")
)