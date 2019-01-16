package com.example.iurymiguel.retrofitexample.api

import com.example.iurymiguel.retrofitexample.pojos.AuthenticationResponse
import com.example.iurymiguel.retrofitexample.models.LoggedUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("register")
    fun signUp(@Body user: LoggedUser): Call<AuthenticationResponse>

}