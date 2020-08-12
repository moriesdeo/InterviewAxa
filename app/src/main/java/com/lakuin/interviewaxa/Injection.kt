package com.lakuin.interviewaxa

import android.app.Application
import androidx.lifecycle.ViewModelProvider

object Injection {
    fun provideViewModelFactory(application: Application): ViewModelProvider.Factory {
        return ViewModelFactory(application)
    }
}