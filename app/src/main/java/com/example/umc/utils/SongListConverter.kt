package com.example.umc.utils

import androidx.room.TypeConverter
import com.example.umc.data.entities.Song
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SongListConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromSongList(songs: List<Song>?): String? {
        if (songs == null) {
            return null
        }
        val type = object : TypeToken<List<Song>>() {}.type
        return gson.toJson(songs, type)
    }

    @TypeConverter
    fun toSongList(songListString: String?): List<Song>? {
        if (songListString == null) {
            return null
        }
        val type = object : TypeToken<List<Song>>() {}.type
        return gson.fromJson(songListString, type)
    }
}