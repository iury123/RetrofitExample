package com.example.iurymiguel.retrofitexample.utils

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException

class Utils {
    companion object {
        const val BASE_URL = "https://reqres.in/api/"
        const val TOKEN = "token"

        fun <T> deserializer(retrofit: Retrofit, responseBody: ResponseBody, pojoClass: Class<T>): T? {
            val converter: Converter<ResponseBody, T> = retrofit.responseBodyConverter(
                pojoClass, arrayOf()
            )
            try {
                return converter.convert(responseBody)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

    }
}