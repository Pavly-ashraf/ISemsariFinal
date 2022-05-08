package com.example.isemsari.models

import java.io.Serializable


class AdStatusModel(
    val NameEn: String,
    val NameAr: String,
    val Id: Long,
    val IsDeleted: Boolean,
    val DisplayOrder: Long? = null,
    val IconUrlPath: String? = null
): Serializable