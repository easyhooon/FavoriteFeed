package com.leejihun.supergene.assignment.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.leejihun.supergene.assignment.data.database.FavoritesUserDao
import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesUserDataSourceImpl @Inject constructor(
    private val dao: FavoritesUserDao,
) : FavoritesUserDataSource {
    override suspend fun insertFavoritesUser(userInfo: UserInfo) {
        dao.insertFavoritesUser(userInfo)
    }

    override suspend fun deleteFavoritesUser(userInfo: UserInfo) {
        dao.deleteFavoritesUser(userInfo)
    }

    override fun getFavoritesUserList(): Flow<PagingData<UserInfo>> {
        val pagingSourceFactory = {
            dao.getFavoritesUserList()
        }

        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGING_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}
