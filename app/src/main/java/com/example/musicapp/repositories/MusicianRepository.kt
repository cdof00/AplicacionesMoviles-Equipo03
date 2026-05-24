package com.example.musicapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.example.musicapp.models.Album
import com.example.musicapp.models.CreateAlbum
import com.example.musicapp.models.Musician
import com.example.musicapp.network.NetworkServiceAdapter

class MusicianRepository(val application: Application) {
    fun getMusicianList(
        onComplete: (resp: List<Musician>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getMusicians(onComplete, onError)
    }

    fun getBandList(
        onComplete: (resp: List<Musician>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getBands(onComplete, onError)
    }

    fun associateMusician(artistId: Int, albumId: Int, callback: (resp:Album)->Unit , onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).associateMusician(artistId,albumId, callback, onError)
    }

    fun associateBand(artistId: Int, albumId: Int, callback: (resp:Album)->Unit , onError: (VolleyError)->Unit) {
        NetworkServiceAdapter.getInstance(application).associateBand(artistId, albumId, callback, onError)
    }

    fun refreshMusicianDetail(
        musicianId: Int,
        onComplete: (resp: Musician) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getMusicianDetail(musicianId, onComplete, onError)
    }

    fun refreshBandDetail(
        musicianId: Int,
        onComplete: (resp: Musician) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getBandDetail(musicianId, onComplete, onError)
    }
}