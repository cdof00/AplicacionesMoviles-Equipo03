package com.example.musicapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicapp.models.Album
import com.example.musicapp.models.CreateAlbum
import com.example.musicapp.models.Musician
import com.example.musicapp.repositories.AlbumRepository
import com.example.musicapp.repositories.MusicianRepository
import com.example.musicapp.ui.states.CreateAlbumUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CreateAlbumViewModel(application: Application) :  AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(CreateAlbumUiState())
    val uiState: StateFlow<CreateAlbumUiState> = _uiState

    var createdAlbumId = MutableStateFlow(0)

    val isLoading = MutableStateFlow(false)

    private val albumsRepository = AlbumRepository(application)
    private val musicianRepository = MusicianRepository(application)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    private var _response = MutableLiveData<Album>()

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        this.refreshDataFromNetwork()
    }

    fun createAlbum() {

        isLoading.value = true
        var album = CreateAlbum(name = uiState.value.albumTitle, cover = uiState.value.artwork, releaseDate = uiState.value.year, description = uiState.value.description, genre = uiState.value.genre, recordLabel = uiState.value.recordLabel)
        var artist = uiState.value.artist
        var albumId = 0
        Log.d("CreateAlbumVM", "Artist: ${artist}")
        albumsRepository.createAlbum(album,{
            _response.value = it
            albumId = it.albumId
            musicianRepository.associateMusician(artist.musicianId,albumId,{
                _response.value = it
                isLoading.value = false
                _uiState.value.artwork = ""
                _uiState.value.albumTitle= ""
                _uiState.value.artist = Musician(0,"","","","")
                _uiState.value.year = ""
                _uiState.value.genre = ""
                _uiState.value.description = ""
                _uiState.value.recordLabel = ""
                _uiState.value.tracks = emptyList()
                createdAlbumId.value = it.albumId
            },{
                musicianRepository.associateBand(artist.musicianId,albumId,{
                    _response.value = it
                    isLoading.value = false
                    _uiState.value.artwork = ""
                    _uiState.value.albumTitle= ""
                    _uiState.value.artist = Musician(0,"","","","")
                    _uiState.value.year = ""
                    _uiState.value.genre = ""
                    _uiState.value.description = ""
                    _uiState.value.recordLabel = ""
                    _uiState.value.tracks = emptyList()
                    createdAlbumId.value = it.albumId
                },{
                    _eventNetworkError.value = true
                })
            })
        },{
            _eventNetworkError.value = true
        })
    }
    private fun refreshDataFromNetwork() {
        viewModelScope.launch() {
        }
    }
}