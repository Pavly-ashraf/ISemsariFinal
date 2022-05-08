package com.example.isemsari.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    val token: String
)
