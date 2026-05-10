package com.example.musicapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.example.musicapp.models.Musician
import com.example.musicapp.network.NetworkServiceAdapter

class MusicianRepository(val application: Application) {
    fun getMusicianList(
        onComplete: (resp: List<Musician>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getMusicians(onComplete, onError)
    }

    fun refreshMusicianDetail(
        musicianId: Int,
        onComplete: (resp: Musician) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        NetworkServiceAdapter.getInstance(application).getMusicianDetail(musicianId, onComplete, onError)
    }
}