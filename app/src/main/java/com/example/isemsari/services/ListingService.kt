package com.example.isemsari.services

import com.example.isemsari.models.SpsonsoredListResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ListingService {

//    @Headers(
//        "Content-Type: application/json"
//    )
    @GET("Ad/GetAdsBySponsorTypeId")
    fun getHomeList(
        @Query("PageNum") PageNum: String,
        @Query("SponsorTypeId") SponsorTypeId: String
    ): Call<List<SpsonsoredListResponseModel>>

    @GET("Ad/GetAdsBySponsorTypeId")
    suspend fun getHomeListCoroutines(
        @Query("PageNum") PageNum: String,
        @Query("SponsorTypeId") SponsorTypeId: String
    ) : List<SpsonsoredListResponseModel>

}