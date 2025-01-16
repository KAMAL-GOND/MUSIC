package com.example.music

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterFace {



    @Headers("x-rapidapi-key: 81018dfb9bmsh0544d1c16b6b180p1ae9b8jsn2c705c1f713b",
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com")

    @GET("Search")
    fun getData(@Query("q") query:String): Call<MyData>
}