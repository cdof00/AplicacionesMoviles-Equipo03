package com.example.musicapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.musicapp.repositories.MusicianRepository
import com.example.musicapp.ui.states.MusicianDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicianViewModel(application: Application, musicianId: Int) :
    AndroidViewModel(application) {

    private val _musicianDetail = MutableStateFlow(MusicianDetailUiState())
    val musicianDetail: StateFlow<MusicianDetailUiState> = _musicianDetail

    private val musicianRepository = MusicianRepository(application)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    val id: Int = musicianId

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        viewModelScope.launch {
            musicianRepository.refreshMusicianDetail(id, {
                android.util.Log.d("MusicianVM", "Musician: ${it.name}, Albums: ${it.albums.size}")
                _musicianDetail.value = MusicianDetailUiState(it)
            }, {
                musicianRepository.refreshBandDetail(id, {
                    android.util.Log.d("MusicianVM", "Musician: ${it.name}, Albums: ${it.albums.size}")
                    _musicianDetail.value = MusicianDetailUiState(it)
                }, {
                    _eventNetworkError.value = true
                })
            })
        }
    }

    class Factory(val app: Application, private val musicianId: Int) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(MusicianViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MusicianViewModel(app, musicianId) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}