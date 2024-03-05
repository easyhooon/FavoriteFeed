package com.kenshi.favoritefeed.data.service

import com.kenshi.favoritefeed.data.model.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("api/")
    suspend fun getRandomUserList(
        @Query("results") results: Int,
        @Query("inc") inc: String,
        @Query("page") page: Int,
    ): RandomUserResponse
}
