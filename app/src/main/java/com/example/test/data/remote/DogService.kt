package com.example.test.data.remote

import com.example.test.model.DogResponse
import com.example.test.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}
