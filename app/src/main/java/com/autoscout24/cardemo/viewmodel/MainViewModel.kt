package com.autoscout24.cardemo.viewmodel

import androidx.navigation.NavController
import com.autoscout24.cardemo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ParentViewModel() {
    lateinit var navController: NavController
}