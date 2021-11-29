package com.autoscout24.cardemo.repository

import com.autoscout24.cardemo.mockjson.JSON
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import com.google.gson.Gson
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.google.gson.reflect.TypeToken
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Response

@ExperimentalCoroutinesApi
class CarRepositoryTest {

    private lateinit var carRepository: CarRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        carRepository = mockk()
    }

    @Test
    fun executeCarDetails() {
        runBlockingTest {
            withGetCarSuccessful()
            val result = carRepository.getAllCars()
            assertEquals(1,result[0].id)
        }
    }

    @Test
    fun executeNotes() {
        runBlockingTest {
            withGetNotes()
            val resultNotes = carRepository.getNotes()
            assertEquals(2,resultNotes[0].vehicleId)
        }
    }


    private fun withGetCarSuccessful() = runBlockingTest {
        val myType = object : TypeToken<List<CarDetailsItem>>() {}.type
        val data = Gson().fromJson<List<CarDetailsItem>>(JSON.getAllCars, myType)
        val response = Response.success(data)
        coEvery { carRepository.getAllCars() } returns response.body()!!
    }


    private fun withGetNotes() = runBlockingTest {
        val myType = object : TypeToken<List<CarNotesItem>>() {}.type
        val data = Gson().fromJson<List<CarNotesItem>>(JSON.getNotes, myType)
        val response = Response.success(data)
        coEvery { carRepository.getNotes() } returns response.body()!!
    }

}