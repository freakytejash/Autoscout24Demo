package com.autoscout24.cardemo.viewmodel

import com.autoscout24.cardemo.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val carRepository: CarRepository) : ParentViewModel()