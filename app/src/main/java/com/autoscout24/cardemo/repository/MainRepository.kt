package com.autoscout24.cardemo.repository

import com.autoscout24.cardemo.BuildConfig
import com.autoscout24.cardemo.network.RetrofitService
import com.autoscout24.cardemo.network.SafeApiRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository
@Inject
constructor(private val retrofitService: RetrofitService): SafeApiRequest() {

    suspend fun getAllCars() = execute { retrofitService.getAllCars() }
    suspend fun getNotes() = execute { retrofitService.getNotes(BuildConfig.NOTES_URL) }
}