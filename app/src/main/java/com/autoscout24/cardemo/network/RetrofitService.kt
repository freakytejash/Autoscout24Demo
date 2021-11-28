package com.autoscout24.cardemo.network

import com.autoscout24.cardemo.BuildConfig
import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET(".")
    suspend fun getAllCars() : Response<List<CarDetailsItem>>

    @GET
    suspend fun getNotes(@Url url:String) : Response<List<CarNotesItem>>

}