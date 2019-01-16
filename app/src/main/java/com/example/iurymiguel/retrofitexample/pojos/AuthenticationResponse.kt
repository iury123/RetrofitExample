package com.example.iurymiguel.retrofitexample.pojos

import com.google.gson.annotations.SerializedName

class AuthenticationResponse {
    @SerializedName("token")
    lateinit var token: String //When the name of the variable is the same of the JSON's one, it is not necessary @SerializedName.
}

class AuthenticationError {
    @SerializedName("error")
    lateinit var error: String
}