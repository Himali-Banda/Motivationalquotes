package com.example.mymotivationquotesapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Get request
    @GET("quotes")
   //function that return a list of QuotesModel
   fun getRandomQuotes():Call<List<QuotesModel>>
}