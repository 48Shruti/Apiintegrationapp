package com.shruti.apiintegrationapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @Headers("x-rapidapi-key: bcf576e2ecmsh8d4af5b1d6f4110p1db621jsnb9ab811043b2",
        "x-rapidapi-host: quotes21.p.rapidapi.com")
    @GET("quote")
    fun listQuotes() : Call<QuotesDataClass>
}