package com.autoscout24.cardemo.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.autoscout24.cardemo.repository.CarRepository
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import com.autoscout24.cardemo.network.ApiException
import com.autoscout24.cardemo.util.UNIVERSAL_ERROR_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carRepository: CarRepository) : ParentViewModel() {

    val carList = MutableLiveData<List<CarDetailsItem>>()
    val loader: ObservableBoolean = ObservableBoolean(false)

    fun getAllCars() = viewModelScope.launch(Dispatchers.IO) {

        try {
            loader.set(true)
            val carResult = async {carRepository.getAllCars()}
            val carResponse = carResult.await()
            val notesResult = async { carRepository.getNotes() }
            val noteResponse = notesResult.await()

            carList.postValue(addNotesInCar(carResponse,noteResponse))

        } catch (e: ApiException) {
            errorMutableLiveData.postValue(e.message ?: UNIVERSAL_ERROR_MESSAGE)
        } finally {
            loader.set(false)
        }
    }


    fun addNotesInCar(cars: List<CarDetailsItem>, notes: List<CarNotesItem>): List<CarDetailsItem> {
        cars.forEach {
                carDetailsItem -> notes.forEach {
            if (carDetailsItem.id==it.vehicleId)
                carDetailsItem.note=it
            }
        }
        return cars
    }
}