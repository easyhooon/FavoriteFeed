package com.kenshi.favoritefeed.data.datasource

import com.kenshi.favoritefeed.data.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface FavoritesUserDataSource {
    suspend fun insertFavoritesUser(userInfo: UserInfo)
    suspend fun deleteFavoritesUser(userInfo: UserInfo)
    fun getFavoritesUserList(): Flow<List<UserInfo>>
    suspend fun updateFavoritesUser(userInfo: UserInfo)
}
