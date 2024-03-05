package com.kenshi.favoritefeed.data.datasource

import com.kenshi.favoritefeed.core.database.FavoritesUserDao
import com.kenshi.favoritefeed.data.mapper.toDBEntity
import com.kenshi.favoritefeed.data.mapper.toModel
import com.kenshi.favoritefeed.data.model.UserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoritesUserDataSourceImpl @Inject constructor(
    private val dao: FavoritesUserDao,
) : FavoritesUserDataSource {
    override suspend fun insertFavoritesUser(userInfo: UserInfo) {
        dao.insertFavoritesUser(userInfo.toDBEntity())
    }

    override suspend fun deleteFavoritesUser(userInfo: UserInfo) {
        dao.deleteFavoritesUser(userInfo.toDBEntity())
    }

    override fun getFavoritesUserList(): Flow<List<UserInfo>> {
        return dao.getFavoritesUserList().map { users ->
            users.map { user ->
                user.toModel()
            }
        }
    }

    override suspend fun updateFavoritesUser(userInfo: UserInfo) {
        dao.updateFavoritesUser(userInfo.email, userInfo.isLiked)
    }
}
