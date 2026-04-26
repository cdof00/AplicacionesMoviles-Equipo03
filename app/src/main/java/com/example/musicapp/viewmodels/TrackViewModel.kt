package com.example.musicapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.musicapp.models.Album
import com.example.musicapp.repositories.AlbumRepository
import com.example.musicapp.repositories.TrackRepository
import com.example.musicapp.ui.states.TrackAlbumUiState
import com.example.musicapp.ui.states.TrackListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class TrackViewModel(application: Application, albumId: Int) :  AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(TrackListUiState())
    val uiState: StateFlow<TrackListUiState> = _uiState

    private val _album = MutableStateFlow(TrackAlbumUiState())

    val album: StateFlow<TrackAlbumUiState> = _album

    private val tracksRepository = TrackRepository(application)
    private val albumRepository = AlbumRepository(application)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    val id:Int = albumId

    init {
        this.refreshDataFromNetwork()
    }
    private fun refreshDataFromNetwork() {
        viewModelScope.launch() {
            tracksRepository.refreshData(id,{
                _uiState.value = TrackListUiState(it)
            },{
                _eventNetworkError.value = true
            })
            albumRepository.refreshData({
                val album = getAlbumById(it, id)
                _album.value = TrackAlbumUiState(album)
            },{
                _eventNetworkError.value = true
            })
        }
    }

    private fun getAlbumById(albums: List<Album>, albumId: Int):Album{
        val index = albums.indexOfFirst{
            it.albumId == albumId
        }
        return albums[index]
    }

    class Factory(val app: Application, private val albumId: Int) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(TrackViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrackViewModel(app, albumId) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}