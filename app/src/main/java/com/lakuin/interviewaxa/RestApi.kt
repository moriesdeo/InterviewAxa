package com.lakuin.interviewaxa

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface RestApi {

    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("posts")
    fun getData(
    ): Call<ArrayList<ResponseMain>>

    companion object {

        fun create(): RestApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logger)

            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApi::class.java)
        }
    }
}