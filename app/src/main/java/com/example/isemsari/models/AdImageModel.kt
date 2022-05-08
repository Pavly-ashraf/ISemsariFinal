package com.example.isemsari.models

import java.io.Serializable

data class AdImageModel(
    val ImagePathUrl: String,
    val IsMainImage: Boolean,
    val AdId: Long,
    val Id: Long,
    val IsDeleted: Boolean
): Serializable