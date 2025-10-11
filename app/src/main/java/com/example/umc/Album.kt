package com.example.umc.com.example.umc

import com.example.umc.Song

data class Album(
    var title : String? = "" ,
    var singer : String? = "",
    var coverImg : Int? = null,
    var songs : ArrayList<Song>? = null
)