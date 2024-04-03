package com.example.myapplication.service

import com.example.myapplication.model.Animal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {
    @Headers("X-Api-Key: ElqMss+wW3hjbSYu4EfREA==w0Q5vW61RHTnY4wx")
    @GET("v1/animals")
    fun fetchAnimalsList(@Query("name") animal:String): Call<List<Animal>>

}