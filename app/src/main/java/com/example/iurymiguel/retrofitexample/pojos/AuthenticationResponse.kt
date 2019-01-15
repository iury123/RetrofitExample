package com.example.iurymiguel.retrofitexample.pojos

import com.google.gson.annotations.SerializedName

class AuthenticationResponse {

    @SerializedName("token")
    lateinit var mToken: String

    @SerializedName("error")
    lateinit var mError: String

}