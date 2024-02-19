package com.leejihun.supergene.assignment.data.datasource

import androidx.paging.PagingData
import com.leejihun.supergene.assignment.data.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface FavoritesUserDataSource {
    suspend fun insertFavoritesUser(userInfo: UserInfo)
    suspend fun deleteFavoritesUser(userInfo: UserInfo)
    fun getFavoritesUserList(): Flow<PagingData<UserInfo>>
}
