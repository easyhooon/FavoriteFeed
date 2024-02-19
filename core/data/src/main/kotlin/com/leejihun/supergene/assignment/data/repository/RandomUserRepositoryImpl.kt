package com.leejihun.supergene.assignment.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.leejihun.supergene.assignment.data.datasource.RandomUserDataSource
import com.leejihun.supergene.assignment.data.mapper.toEntity
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val dataSource: RandomUserDataSource,
) : RandomUserRepository {
    override fun getUserList(): Flow<PagingData<UserInfoEntity>> {
        return dataSource.getRandomUserList().map { pagingData ->
            pagingData.map { user ->
                user.toEntity()
            }
        }
    }
}
