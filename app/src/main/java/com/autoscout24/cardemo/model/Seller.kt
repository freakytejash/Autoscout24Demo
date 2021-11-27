package com.autoscout24.cardemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Seller(
    val city: String,
    val phone: String,
    val type: String
) : Parcelable