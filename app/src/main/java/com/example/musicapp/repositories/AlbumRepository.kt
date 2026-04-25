package com.example.musicapp.repositories

import android.app.Application
import android.util.Log
import com.android.volley.VolleyError
import com.example.musicapp.models.Album
import com.example.musicapp.network.NetworkServiceAdapter

class AlbumRepository (val application: Application){
    fun refreshData(callback: (List<Album>)->Unit, onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).getAlbums({
            callback(it)
        },
            onError
        )
    }
}