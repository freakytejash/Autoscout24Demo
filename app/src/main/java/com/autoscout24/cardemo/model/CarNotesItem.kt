package com.autoscout24.cardemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarNotesItem(
    val note: String,
    val vehicleId: Int
) : Parcelable