package com.kenshi.favoritefeed.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kenshi.favoritefeed.data.model.UserInfo
import com.kenshi.favoritefeed.data.paging.RandomUserPagingSource
import com.kenshi.favoritefeed.data.service.RandomUserService
import com.kenshi.favoritefeed.data.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RandomUserDataSourceImpl @Inject constructor(
    private val service: RandomUserService,
) : RandomUserDataSource {
    override fun getRandomUserList(): Flow<PagingData<UserInfo>> {
        val pagingSourceFactory = {
            RandomUserPagingSource(service)
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
