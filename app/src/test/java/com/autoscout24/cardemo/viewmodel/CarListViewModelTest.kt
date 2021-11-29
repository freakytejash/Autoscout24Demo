package com.autoscout24.cardemo.viewmodel

import com.autoscout24.cardemo.mockjson.JSON
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import com.autoscout24.cardemo.repository.CarRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CarListViewModelTest {

    private lateinit var viewModel: CarListViewModel
    private lateinit var carRepository: CarRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        carRepository = mockk()
        viewModel = CarListViewModel(carRepository)
    }

    @Test
    fun `Test notes and car details`(){
        val myType = object : TypeToken<List<CarDetailsItem>>() {}.type
        val carData = Gson().fromJson<List<CarDetailsItem>>(JSON.getAllCars, myType)

        val myTypeNotes = object : TypeToken<List<CarNotesItem>>() {}.type
        val dataNotes = Gson().fromJson<List<CarNotesItem>>(JSON.getNotes, myTypeNotes)

        val addResults = viewModel.addNotesInCar(carData,dataNotes)
        assertEquals(dataNotes[0].vehicleId, addResults[1].note?.vehicleId)
    }
}