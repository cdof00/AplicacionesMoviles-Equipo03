package com.example.musicapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.example.musicapp.models.Track
import com.example.musicapp.network.NetworkServiceAdapter

class TrackRepository (val application: Application){
    fun refreshData(albumId: Int, callback: (List<Track>)->Unit, onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).getTracks(albumId,{
            callback(it)
        },
            onError
        )
    }
}