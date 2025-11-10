package com.example.umc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.umc.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.jvm.java


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
        val loginButton: Button = view.findViewById(R.id.locker_login_tv)

        loginButton.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)

            startActivity(intent)

        }

//        lockerAdapter.addFragment(SavedSongFragment())
//        lockerAdapter.addFragment(MusicFileFragment())
//        lockerAdapter.addFragment(SavedAlbumFragment())

        binding.lockerContentVp.adapter = lockerAdapter

        // TabLayout과 ViewPager2 연동
        TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp) { tab, position ->
            tab.text = information[position]
        }.attach()

        binding.lockerContentVp.setCurrentItem(2, false)
    }
}