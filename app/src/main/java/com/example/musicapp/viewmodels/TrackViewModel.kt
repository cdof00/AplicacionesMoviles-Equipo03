package com.example.musicapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.musicapp.repositories.AlbumRepository
import com.example.musicapp.repositories.TrackRepository
import com.example.musicapp.ui.states.TrackAlbumUiState
import com.example.musicapp.ui.states.TrackListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrackViewModel(application: Application, albumId: Int) :
    AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(TrackListUiState())
    val uiState: StateFlow<TrackListUiState> = _uiState

    private val _album = MutableStateFlow(TrackAlbumUiState())
    val album: StateFlow<TrackAlbumUiState> = _album

    private val tracksRepository = TrackRepository(application)
    private val albumRepository = AlbumRepository(application)

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isCreatingTrack = MutableStateFlow(false)
    val isCreatingTrack: StateFlow<Boolean> = _isCreatingTrack

    private val _trackCreatedSuccessfully = MutableStateFlow(false)
    val trackCreatedSuccessfully: StateFlow<Boolean> = _trackCreatedSuccessfully

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    val id: Int = albumId

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        _isLoading.value = true

        viewModelScope.launch {
            refreshTracks()
            refreshAlbum()
        }
    }

    private fun refreshTracks() {
        tracksRepository.refreshData(
            id,
            { tracks ->
                Log.d("TrackVM", "Tracks: $tracks")
                _uiState.value = TrackListUiState(tracks)
                _isLoading.value = false
            },
            { error ->
                Log.e("TrackVM", "Error cargando tracks: ${error.message}")
                _eventNetworkError.value = true
                _isLoading.value = false
            }
        )
    }

    private fun refreshAlbum() {
        albumRepository.getAlbumById(
            id,
            { albumData ->
                Log.d("TrackVM", "Album: $albumData")
                _album.value = TrackAlbumUiState(albumData)
            },
            { error ->
                Log.e("TrackVM", "Error cargando álbum: ${error.message}")
                _eventNetworkError.value = true
            }
        )
    }

    fun createTrack(
        name: String,
        duration: String
    ) {
        if (_isCreatingTrack.value) return

        val cleanName = name.trim()
        val cleanDuration = duration.trim()

        if (cleanName.isBlank() || cleanDuration.isBlank()) return

        _isCreatingTrack.value = true
        _trackCreatedSuccessfully.value = false

        tracksRepository.createTrack(
            id,
            cleanName,
            cleanDuration,
            { createdTrack ->
                Log.d("TrackVM", "Track creada: ${createdTrack.name}")

                _trackCreatedSuccessfully.value = true
                _isCreatingTrack.value = false

                refreshTracks()
            },
            { error ->
                Log.e("TrackVM", "Error creando track: ${error.message}")

                _eventNetworkError.value = true
                _isCreatingTrack.value = false
            }
        )
    }

    fun resetTrackCreatedFlag() {
        _trackCreatedSuccessfully.value = false
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
        _eventNetworkError.value = false
    }

    class Factory(
        val app: Application,
        private val albumId: Int
    ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            if (modelClass.isAssignableFrom(TrackViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrackViewModel(app, albumId) as T
            }

            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}