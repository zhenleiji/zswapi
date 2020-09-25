package com.zji.starwars

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zji.starwars.databinding.FragmentMainBinding
import com.zji.starwars.extension.viewBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding<FragmentMainBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainFragmentTextView.text = "Fragment Showed"
    }
}
