package com.autoscout24.cardemo.network

class ApiException(errorMessage: String, statusCode: Int) : RuntimeException(errorMessage)
