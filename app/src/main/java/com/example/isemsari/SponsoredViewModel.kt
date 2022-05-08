package com.example.isemsari

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.isemsari.models.SpsonsoredListResponseModel
import com.example.isemsari.repository.MainRepository
import com.example.isemsari.repository.Result
import kotlinx.coroutines.launch

class SponsoredViewModel : ViewModel() {
    private val repository = MainRepository()

    val liveData = MutableLiveData<Result<List<SpsonsoredListResponseModel>>>()

    fun getHomeListCoroutines(pageNum: String, typeId: String) = viewModelScope.launch {
        liveData.value = Result.Loading()
        liveData.value = repository.getHomeListCoroutines(pageNum, typeId)
    }
}