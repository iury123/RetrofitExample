package com.example.iurymiguel.retrofitexample.interfaces

interface ConnectionCallbacks {
    fun onSuccessConnection(response: Any? = null)
    fun onFailedConnected(error: Any? = null)
}