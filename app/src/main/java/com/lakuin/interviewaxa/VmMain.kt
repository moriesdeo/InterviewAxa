package com.lakuin.interviewaxa

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VmMain(application: Application) : ViewModel() {
    private val repositoryMain = RepositoryMain(application)

    internal fun getData(): LiveData<ArrayList<ResponseMain>> {
        val data = MutableLiveData<ArrayList<ResponseMain>>()
        repositoryMain.getData {
            run {
                data.postValue(it)
            }
        }
        return data
    }
}