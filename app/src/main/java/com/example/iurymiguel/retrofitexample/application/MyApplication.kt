package com.example.iurymiguel.retrofitexample.application

import android.app.Application
import com.example.iurymiguel.retrofitexample.providers.ProgressDialogProvider
import com.example.iurymiguel.retrofitexample.providers.RetrofitProvider
import com.example.iurymiguel.retrofitexample.providers.SharedPreferencesProvider
import com.example.iurymiguel.retrofitexample.viewmodels.AuthenticationViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MyApplication : Application() {

    private val appModule = module {
        single { RetrofitProvider() }
        single { ProgressDialogProvider() }
        single { SharedPreferencesProvider(androidContext()) }
        viewModel { AuthenticationViewModel(get(), get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}