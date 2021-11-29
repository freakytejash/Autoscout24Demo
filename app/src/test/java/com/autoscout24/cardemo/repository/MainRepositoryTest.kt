package com.autoscout24.cardemo.repository

import android.net.http.HttpResponseCache
import com.autoscout24.cardemo.mockjson.JSON
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import com.autoscout24.cardemo.network.RetrofitService
import com.google.gson.Gson
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import com.google.gson.reflect.TypeToken
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.http.HTTP

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    private lateinit var mainRepository: MainRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mainRepository = mockk()
    }

    @Test
    fun execute() {
        runBlockingTest {
            withGetCarSuccessful()
            val result = mainRepository.getAllCars()
            assertEquals(1,result[0].id)

            withGetNotes()
            val resultNotes = mainRepository.getNotes()
            assertEquals(2,resultNotes[0].vehicleId)
        }
    }


    private fun withGetCarSuccessful() = runBlockingTest {
        val myType = object : TypeToken<List<CarDetailsItem>>() {}.type
        val data = Gson().fromJson<List<CarDetailsItem>>(JSON.getAllCars, myType)
        val response = Response.success(data)
        coEvery { mainRepository.getAllCars() } returns response.body()!!
    }


    private fun withGetNotes() = runBlockingTest {
        val myType = object : TypeToken<List<CarNotesItem>>() {}.type
        val data = Gson().fromJson<List<CarNotesItem>>(JSON.getNotes, myType)
        val response = Response.success(data)
        coEvery { mainRepository.getNotes() } returns response.body()!!
    }

}