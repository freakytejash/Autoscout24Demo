package com.autoscout24.cardemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.autoscout24.cardemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setupNavGraph()
    }

    /*private fun setupNavGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        viewModel.navController = navHostFragment.navController
    }*/
}