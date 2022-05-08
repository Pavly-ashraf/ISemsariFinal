package com.example.isemsari.repository

import com.example.isemsari.models.SpsonsoredListResponseModel
import com.example.isemsari.services.ListingService
import com.example.isemsari.services.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class MainRepository {
    private val retrofit =ServiceBuilder.builder.build().create(ListingService::class.java)

    suspend fun getHomeListCoroutines(pageNum: String, sponserTypeId: String): Result<List<SpsonsoredListResponseModel>>{
       return withContext(Dispatchers.IO){
            try {
                val response = retrofit.getHomeListCoroutines(pageNum, sponserTypeId)
                Result.Success(response)
            }catch (e: Throwable){
                when(e){
                    is IOException -> {
                        Result.Error("internet connection is not stable")
                    }
                    else -> {
                        Result.Error("Something  went error")
                    }
                }
            }
        }
    }
}