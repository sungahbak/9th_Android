package com.example.umc

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

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