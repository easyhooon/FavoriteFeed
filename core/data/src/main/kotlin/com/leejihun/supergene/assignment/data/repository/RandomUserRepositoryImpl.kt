package com.leejihun.supergene.assignment.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.leejihun.supergene.assignment.data.datasource.FavoritesUserDataSource
import com.leejihun.supergene.assignment.data.datasource.RandomUserDataSource
import com.leejihun.supergene.assignment.data.mapper.toEntity
import com.leejihun.supergene.assignment.data.mapper.toModel
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RandomUserDataSource,
    private val localDataSource: FavoritesUserDataSource,
) : RandomUserRepository {
    override fun getUserList(): Flow<PagingData<UserInfoEntity>> {
        return remoteDataSource.getRandomUserList().map { pagingData ->
            pagingData.map { user ->
                user.toEntity()
            }
        }
    }

    override fun getFavoritesUserList(): Flow<PagingData<UserInfoEntity>> {
        return localDataSource.getFavoritesUserList().map { pagingData ->
            pagingData.map { user ->
                user.toEntity()
            }
        }
    }

    override suspend fun insertFavoritesUser(userInfo: UserInfoEntity) {
        localDataSource.insertFavoritesUser(userInfo.toModel())
    }

    override suspend fun deleteFavoritesUser(userInfo: UserInfoEntity) {
        localDataSource.deleteFavoritesUser(userInfo.toModel())
    }
}
