package com.kenshi.favoritefeed.data.datasource

import androidx.paging.PagingData
import com.kenshi.favoritefeed.data.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface RandomUserDataSource {
    fun getRandomUserList(): Flow<PagingData<UserInfo>>
}
