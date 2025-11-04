package com.example.umc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator


class LockerFragment : Fragment() {
    private lateinit var binding: FragmentLockerBinding
    private val information = arrayListOf("저장한 곡", "음악파일", "저장앨범")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLockerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val lockerAdapter = LockerVPAdapter(this)


        lockerAdapter.addFragment(SavedSongFragment())
        lockerAdapter.addFragment(MusicFileFragment())
        lockerAdapter.addFragment(SavedAlbumFragment())

        binding.lockerContentVp.adapter = lockerAdapter

        // TabLayout과 ViewPager2 연동
        TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp) { tab, position ->
            tab.text = information[position]
        }.attach()

        // 앱이 시작될 때 '저장앨범' 탭(인덱스 2)을 선택하도록 설정
        binding.lockerContentVp.setCurrentItem(2, false)
    }
}