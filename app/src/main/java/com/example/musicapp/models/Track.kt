package com.example.musicapp.models

data class Track (
    val trackId: Int,
    val name:String,
    val duration:String,
    val albumId:Int
)

data class CreateTrack(
    var name:String,
    var duration:String,
)