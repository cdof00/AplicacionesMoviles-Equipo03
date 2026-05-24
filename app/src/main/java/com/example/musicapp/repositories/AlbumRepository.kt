package com.example.musicapp.repositories

import android.app.Application
import android.util.Log
import com.android.volley.VolleyError
import com.example.musicapp.models.Album
import com.example.musicapp.models.CreateAlbum
import com.example.musicapp.network.NetworkServiceAdapter
import org.json.JSONObject

class AlbumRepository (val application: Application){
    fun refreshData(callback: (List<Album>)->Unit, onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).getAlbums({
            callback(it)
        },
            onError
        )
    }

    fun getAlbumById(albumId: Int, callback: (Album)->Unit, onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).getAlbumById(albumId, callback, onError)
    }

    fun createAlbum(album: CreateAlbum, callback: (resp:Album)->Unit , onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).createAlbum(album, callback, onError)
    }

}