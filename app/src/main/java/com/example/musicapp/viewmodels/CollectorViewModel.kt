package com.example.musicapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.musicapp.repositories.CollectorRepository
import com.example.musicapp.ui.states.CollectorDetailUiState
import com.example.musicapp.ui.states.CollectorListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CollectorViewModel(application: Application, collectorId: Int) :
    AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(CollectorListUiState())
    val uiState: StateFlow<CollectorListUiState> = _uiState

    private val _collectorDetail = MutableStateFlow(CollectorDetailUiState())
    val collectorDetail: StateFlow<CollectorDetailUiState> = _collectorDetail

    private val collectorRepository = CollectorRepository(application)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    val id: Int = collectorId

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        viewModelScope.launch {
            collectorRepository.refreshData({
                _uiState.value = CollectorListUiState(it)
            }, {
                _eventNetworkError.value = true
            })
            collectorRepository.refreshCollectorDetail(id, {
                _collectorDetail.value = CollectorDetailUiState(it)
            }, {
                _eventNetworkError.value = true
            })
        }
    }

    class Factory(val app: Application, private val collectorId: Int) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(CollectorViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CollectorViewModel(app, collectorId) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}