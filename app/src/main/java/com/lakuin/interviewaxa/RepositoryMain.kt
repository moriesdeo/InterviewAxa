package com.lakuin.interviewaxa

import android.app.Application
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryMain(application: Application) {
    private val service = RestApi.create()

    internal fun getData(onResult: (ArrayList<ResponseMain>?) -> Unit) {
        service.getData().enqueue(object : Callback<ArrayList<ResponseMain>> {
            override fun onFailure(call: Call<ArrayList<ResponseMain>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<ResponseMain>>,
                response: Response<ArrayList<ResponseMain>>
            ) {
                if (response.isSuccessful) onResult(response.body())
            }

        })
    }
}