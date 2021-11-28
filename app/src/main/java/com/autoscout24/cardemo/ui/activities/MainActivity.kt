package com.autoscout24.cardemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.autoscout24.cardemo.R
import com.autoscout24.cardemo.repository.MainRepository
import com.autoscout24.cardemo.adapter.CarAdapter
import com.autoscout24.cardemo.databinding.ActivityMainBinding
import com.autoscout24.cardemo.network.RetrofitService
import com.autoscout24.cardemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

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