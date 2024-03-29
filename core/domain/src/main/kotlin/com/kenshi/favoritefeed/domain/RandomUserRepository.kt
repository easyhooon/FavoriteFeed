package com.kenshi.favoritefeed.domain

import androidx.paging.PagingData
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface RandomUserRepository {
    fun getUserList(): Flow<PagingData<UserInfoEntity>>
    fun getFavoritesUserList(): Flow<List<UserInfoEntity>>
    suspend fun insertFavoritesUser(userInfo: UserInfoEntity)
    suspend fun deleteFavoritesUser(userInfo: UserInfoEntity)
    suspend fun updateFavoritesUser(userInfo: UserInfoEntity)
}
