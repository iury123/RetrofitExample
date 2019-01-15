package com.example.iurymiguel.retrofitexample.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.iurymiguel.retrofitexample.api.AuthAPI
import com.example.iurymiguel.retrofitexample.interfaces.ConnectionCallbacks
import com.example.iurymiguel.retrofitexample.pojos.AuthenticationResponse
import com.example.iurymiguel.retrofitexample.pojos.LoggedUser
import com.example.iurymiguel.retrofitexample.providers.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel(private val retrofitProvider: RetrofitProvider) : ViewModel() {

    private val authApi: AuthAPI = retrofitProvider.retrofit.create(AuthAPI::class.java)

    fun signIn(loggedUser: LoggedUser) {

    }


    fun signUp(loggedUser: LoggedUser, callback: ConnectionCallbacks) {

        val call: Call<AuthenticationResponse> = authApi.signUp(loggedUser)
        call.enqueue(object : Callback<AuthenticationResponse> {
            override fun onResponse(call: Call<AuthenticationResponse>, response: Response<AuthenticationResponse>) {
                response.body()?.let {
                    callback.onSuccessConnection()
                } ?: run {
                    response.errorBody()?.let {
                        callback.onFailedConnected()
                    }
                }
            }

            override fun onFailure(call: Call<AuthenticationResponse>, t: Throwable) {
                callback.onFailedConnected()
            }
        })

    }

}