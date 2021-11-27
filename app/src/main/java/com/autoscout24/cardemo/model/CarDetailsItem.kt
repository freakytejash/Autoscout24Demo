package com.autoscout24.cardemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarDetailsItem(
    val colour: String,
    val description: String,
    val firstRegistration: String,
    val fuel: String,
    val id: Int,
    val images: List<Image>,
    val make: String,
    val mileage: Int,
    val model: String,
    val modelline: String,
    val price: Int,
    val seller: Seller,
    var note: CarNotesItem?= null
) : Parcelable