package com.example.iurymiguel.retrofitexample.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.iurymiguel.retrofitexample.api.AuthAPI
import com.example.iurymiguel.retrofitexample.interfaces.ConnectionCallbacks
import com.example.iurymiguel.retrofitexample.pojos.AuthenticationError
import com.example.iurymiguel.retrofitexample.pojos.AuthenticationResponse
import com.example.iurymiguel.retrofitexample.models.LoggedUser
import com.example.iurymiguel.retrofitexample.providers.RetrofitProvider
import com.example.iurymiguel.retrofitexample.providers.SharedPreferencesProvider
import com.example.iurymiguel.retrofitexample.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel(
    private val retrofitProvider: RetrofitProvider,
    private val mSharedPreferencesProvider: SharedPreferencesProvider
) : ViewModel() {

    private val authApi: AuthAPI = retrofitProvider.retrofit.create(AuthAPI::class.java)

    fun signIn(loggedUser: LoggedUser) {

    }


    fun signUp(loggedUser: LoggedUser, callback: ConnectionCallbacks) {
        val call: Call<AuthenticationResponse> = authApi.signUp(loggedUser)
        call.enqueue(object : Callback<AuthenticationResponse> {
            override fun onResponse(call: Call<AuthenticationResponse>, response: Response<AuthenticationResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val res: AuthenticationResponse = it
                        mSharedPreferencesProvider.putString(Utils.TOKEN, res.token)
                        callback.onSuccessConnection()
                    }
                } else {
                    response.errorBody()?.let {
                        val error = Utils.deserializer(
                            retrofitProvider.retrofit, it, AuthenticationError::class.java
                        )
                        callback.onFailedConnected(error)
                    }
                }
            }

            override fun onFailure(call: Call<AuthenticationResponse>, t: Throwable) {
                callback.onFailedConnected()
            }
        })

    }

}