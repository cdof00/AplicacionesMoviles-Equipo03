package com.example.musicapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicapp.repositories.AlbumRepository
import com.example.musicapp.ui.states.AlbumListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AlbumViewModel(application: Application) :  AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(AlbumListUiState())
    val uiState: StateFlow<AlbumListUiState> = _uiState

    val isLoading = MutableStateFlow(true)

    private val albumsRepository = AlbumRepository(application)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        this.refreshDataFromNetwork()
    }
    fun refreshDataFromNetwork() {
        isLoading.value = true
        viewModelScope.launch() {
            albumsRepository.refreshData({
                _uiState.value = AlbumListUiState(it)
                isLoading.value = false
            },{
                _eventNetworkError.value = true
            })
        }
    }
}