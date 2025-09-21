package com.example.umc

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umc.databinding.Week1Binding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: Week1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding 적용
        binding = Week1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 이미지 클릭 리스너 설정
        binding.happyCard.setOnClickListener {
            resetTextColors()
            binding.happyText.setTextColor(Color.RED)
            Toast.makeText(this, "행복합니다.", Toast.LENGTH_SHORT).show()
        }

        binding.excitedCard.setOnClickListener {
            resetTextColors()
            binding.excitedtext.setTextColor(Color.BLUE)
            Toast.makeText(this, "흥분됩니다.", Toast.LENGTH_SHORT).show()
        }

        binding.normalCard.setOnClickListener {
            resetTextColors()
            binding.normaltext.setTextColor(Color.RED)
            Toast.makeText(this, "그저그래요.", Toast.LENGTH_SHORT).show()
        }

        binding.nervousCard.setOnClickListener {
            resetTextColors()
            binding.nervoustext.setTextColor(Color.GREEN)
            Toast.makeText(this, "긴장되요.", Toast.LENGTH_SHORT).show()
        }

        binding.angryCard.setOnClickListener {
            resetTextColors()
            binding.angrytext.setTextColor(Color.RED)
            Toast.makeText(this, "화가납니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetTextColors() {
        binding.happyText.setTextColor(Color.BLACK)
        binding.excitedtext.setTextColor(Color.BLACK)
        binding.normaltext.setTextColor(Color.BLACK)
        binding.nervoustext.setTextColor(Color.BLACK)
        binding.happyText.setTextColor(Color.BLACK)
    }
}