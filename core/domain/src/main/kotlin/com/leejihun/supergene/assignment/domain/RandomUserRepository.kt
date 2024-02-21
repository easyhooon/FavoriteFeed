package com.leejihun.supergene.assignment.domain

import androidx.paging.PagingData
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface RandomUserRepository {
    fun getUserList(): Flow<PagingData<UserInfoEntity>>
    // fun getFavoritesUserList(): Flow<PagingData<UserInfoEntity>>
    fun getFavoritesUserList(): Flow<List<UserInfoEntity>>
    suspend fun insertFavoritesUser(userInfo: UserInfoEntity)
    suspend fun deleteFavoritesUser(userInfo: UserInfoEntity)
}
