package com.leejihun.supergene.assignment.data.service

import com.leejihun.supergene.assignment.data.model.RandomUserResponse
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
