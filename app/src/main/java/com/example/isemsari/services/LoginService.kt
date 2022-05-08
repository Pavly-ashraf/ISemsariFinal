package com.example.isemsari.services

import com.example.isemsari.models.LoginResponseModel
import com.example.isemsari.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers(
        "Content-Type: application/json"
    )
    @POST("login")
    fun login(
        @Body post: UserModel
    ): Call<LoginResponseModel>


}