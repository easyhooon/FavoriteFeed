package com.leejihun.supergene.assignment.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.leejihun.supergene.assignment.data.database.FavoritesUserDatabase
import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesUserDataSourceImpl @Inject constructor(
    private val database: FavoritesUserDatabase,
) : FavoritesUserDataSource {
    override suspend fun insertFavoritesUser(userInfo: UserInfo) {
        database.favoritesUserDao().insertFavoritesUser(userInfo)
    }

    override suspend fun deleteFavoritesUser(userInfo: UserInfo) {
        database.favoritesUserDao().deleteFavoritesUser(userInfo)
    }

    override fun getFavoritesUserList(): Flow<PagingData<UserInfo>> {
        val pagingSourceFactory = {
            database.favoritesUserDao().getFavoritesUserList()
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
