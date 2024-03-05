package com.kenshi.favoritefeed.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.kenshi.favoritefeed.data.datasource.FavoritesUserDataSource
import com.kenshi.favoritefeed.data.datasource.RandomUserDataSource
import com.kenshi.favoritefeed.data.mapper.toEntity
import com.kenshi.favoritefeed.data.mapper.toModel
import com.kenshi.favoritefeed.domain.RandomUserRepository
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
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

    override fun getFavoritesUserList(): Flow<List<UserInfoEntity>> {
        return localDataSource.getFavoritesUserList().map { users ->
            users.map { user ->
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

    override suspend fun updateFavoritesUser(userInfo: UserInfoEntity) {
        localDataSource.updateFavoritesUser(userInfo.toModel())
    }
}
