package com.example.musicapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.example.musicapp.models.Collector
import com.example.musicapp.network.NetworkServiceAdapter

class CollectorRepository(val application: Application) {

    fun refreshData(
        onComplete: (resp: List<Collector>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getCollectors(onComplete, onError)
    }

    fun refreshCollectorDetail(
        collectorId: Int,
        onComplete: (resp: Collector) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getCollectorDetail(collectorId, onComplete, onError)
    }
}