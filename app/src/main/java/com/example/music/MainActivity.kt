package com.example.music

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val retrofitBuilder= Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterFace::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                val dataList: MyData? = p1.body()
                val textVeiw= findViewById<TextView>(R.id.hello)
                textVeiw.text=dataList.toString()
                Log.d("TAG: onResponse:","onResponse "+p1.body())



            }

            override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                Log.d("TAG: onFailure: " , "onFailure: "+p1.message)


            }
        })
    }
}