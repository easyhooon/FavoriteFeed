package com.leejihun.supergene.assignment.domain

import androidx.paging.PagingData
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface RandomUserRepository {
    fun getUserList(): Flow<PagingData<UserInfoEntity>>
}