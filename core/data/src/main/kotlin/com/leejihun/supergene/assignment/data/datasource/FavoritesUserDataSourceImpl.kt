package com.leejihun.supergene.assignment.data.datasource

import com.leejihun.supergene.assignment.core.database.FavoritesUserDao
import com.leejihun.supergene.assignment.data.mapper.toDBEntity
import com.leejihun.supergene.assignment.data.mapper.toModel
import com.leejihun.supergene.assignment.data.model.UserInfo
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
}
