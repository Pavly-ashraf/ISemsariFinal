package com.example.isemsari.models

import java.io.Serializable


data class SpsonsoredListResponseModel (
    val Facilities: List<AdStatusModel>,
    val Title: String,
    val Description: String,
    val Address: String,
    val Area: Long? = null,
    val Code: String,
    val Floor: String,
    val Rooms: String,
    val Baths: String,
    val Price: Long,
    val Phone: String,
    val PreferCallHourFrom: Long,
    val PreferCallHourTo: Long,
    val FloorPlanUrlPath: String? = null,
    val LocationLongitude: Double,
    val LocationLatitude: Double,
    val ApplicationUserId: String,
    val CityId: Long,
    val DistrictId: Long,
    val AdTypeId: Long,
    val PropertyTypeId: Long,
    val AdStatusId: Long,
    val CreatedDate: String,
    val IsFavorite: Boolean,
    val Distance: Long,
    val PropertyType: AdStatusModel,
    val AdType: AdStatusModel,
    val AdStatus: AdStatusModel,
    val AdImages: List<AdImageModel>,
    val Id: Long,
    val IsDeleted: Boolean
) : Serializable