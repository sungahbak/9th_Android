package com.example.umc.ui.album

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.umc.ui.main.DetailFragment
import com.example.umc.ui.main.VideoFragment
import com.example.umc.ui.song.SongFragment

class AlbumVPadapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SongFragment()
            1 -> DetailFragment()
            else -> VideoFragment()
        }
    }

    override fun getItemCount(): Int = 3
}