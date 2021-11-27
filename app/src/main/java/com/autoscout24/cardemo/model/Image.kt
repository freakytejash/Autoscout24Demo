package com.autoscout24.cardemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val url: String
) : Parcelable