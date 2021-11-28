package com.autoscout24.cardemo.repository

import com.autoscout24.cardemo.mockjson.JSON
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.network.RetrofitService
import com.google.gson.Gson
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import com.google.gson.reflect.TypeToken
import io.mockk.MockK
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Response

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    lateinit var retrofitService: RetrofitService
    lateinit var mainRepository: MainRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        retrofitService = Mockito.mock(RetrofitService::class.java)
        mainRepository = mockk()
    }

    @Test
    fun execute() {
        runBlockingTest {
            withGetCarSuccessful()
            val result = mainRepository.getAllCars()
            // Then receives agencies successfully
            assertEquals(result[0].id,1)
        }

    }

    private fun withGetCarSuccessful() = runBlockingTest {

        val myType = object : TypeToken<List<CarDetailsItem>>() {}.type

        val data = Gson().fromJson<List<CarDetailsItem>>(JSON.getAllCars, myType)

        val response = Response.success(data)

        coEvery { retrofitService.getAllCars() } returns response
    }
}