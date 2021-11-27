package com.autoscout24.cardemo.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotes
import com.autoscout24.cardemo.model.CarNotesItem
import com.autoscout24.cardemo.network.ApiException
import com.autoscout24.cardemo.repository.MainRepository
import com.autoscout24.cardemo.util.UNIVERSAL_ERROR_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarNotesViewModel @Inject constructor(val mainRepository: MainRepository) : ParentViewModel(){


    val loader: ObservableBoolean = ObservableBoolean(false)


}