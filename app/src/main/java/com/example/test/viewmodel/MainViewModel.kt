package com.example.test.viewmodel

import androidx.lifecycle.*
import com.example.test.data.Repository
import com.example.test.model.DogResponse
import com.example.test.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository
) : ViewModel() {

    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<DogResponse>> = _response

    private val _downloadResponse: MutableLiveData<Boolean> = MutableLiveData()
    val downloadResponse = _downloadResponse

    fun fetchDogResponse()
    {
        viewModelScope.launch {
            repository.getDog().collect { values ->
                _response.value = values
            }
        }
    }

}