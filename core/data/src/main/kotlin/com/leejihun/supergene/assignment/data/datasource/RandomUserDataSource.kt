package com.leejihun.supergene.assignment.data.datasource

import androidx.paging.PagingData
import com.leejihun.supergene.assignment.data.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface RandomUserDataSource {
    fun getRandomUserList(): Flow<PagingData<UserInfo>>
}
