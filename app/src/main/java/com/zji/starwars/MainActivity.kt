package com.zji.starwars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zji.starwars.databinding.ActivityMainBinding
import com.zji.starwars.extension.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainActivityTextView.text = "Show Fragment:"
    }
}
