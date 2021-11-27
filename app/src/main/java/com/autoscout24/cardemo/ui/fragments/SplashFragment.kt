package com.autoscout24.cardemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.autoscout24.cardemo.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            delay(3000)
            findNavController().navigate(R.id.action_splashFragment_to_carListFragment)
        }
    }
}