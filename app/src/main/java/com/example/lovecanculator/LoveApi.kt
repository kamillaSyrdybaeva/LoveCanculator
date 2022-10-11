package com.example.lovecanculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
///.addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
///.addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")

interface LoveApi {
    @GET ("getPercentage")
    fun getCalculate (@Query("fname")firstName: String,
                      @Query("sname")secondName:String,
    @Header ("X-RapidAPI-Key")key: String="SIGN-UP-FOR-KEY",
                      @Header("SIGN-UP-FOR-KEY")host: String ="love-calculator.p.rapidapi.com"
    ) :Call<LoveModel >
}