package com.example.umc

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

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