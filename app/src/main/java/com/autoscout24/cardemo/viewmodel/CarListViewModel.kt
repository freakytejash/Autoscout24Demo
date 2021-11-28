package com.autoscout24.cardemo.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.autoscout24.cardemo.repository.MainRepository
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.network.ApiException
import com.autoscout24.cardemo.util.UNIVERSAL_ERROR_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val mainRepository: MainRepository) : ParentViewModel() {

    val carList = MutableLiveData<List<CarDetailsItem>>()
    val loader: ObservableBoolean = ObservableBoolean(false)

    fun getAllCars() = viewModelScope.launch(Dispatchers.IO) {

        try {
            loader.set(true)
            val carResult = async {mainRepository.getAllCars()}
            val carResponse = carResult.await()
            val notesResult = async { mainRepository.getNotes() }
            val noteResponse = notesResult.await()
            carResponse.forEach {
                    carDetailsItem -> noteResponse.forEach {
                        if (carDetailsItem.id==it.vehicleId)
                        carDetailsItem.note=it
                    }
                }

            carList.postValue(carResponse)

        } catch (e: ApiException) {
            errorMutableLiveData.postValue(e.message ?: UNIVERSAL_ERROR_MESSAGE)
        } finally {
            loader.set(false)
        }
    }
}