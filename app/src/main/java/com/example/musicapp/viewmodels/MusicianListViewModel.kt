package com.example.musicapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicapp.repositories.MusicianRepository
import com.example.musicapp.ui.states.MusicianListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicianListViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(MusicianListUiState())
    val uiState: StateFlow<MusicianListUiState> = _uiState

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean> get() = _eventNetworkError

    private val musicianRepository = MusicianRepository(application)

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        viewModelScope.launch {
            _isLoading.value = true
            musicianRepository.getMusicianList(
                { musicians ->
                    _uiState.value = MusicianListUiState(musicians)
                    _isLoading.value = false
                },
                { error ->
                    Log.e("MusicianListVM", error.message ?: "network error")
                    _eventNetworkError.value = true
                    _isLoading.value = false
                }
            )
        }
    }
}
