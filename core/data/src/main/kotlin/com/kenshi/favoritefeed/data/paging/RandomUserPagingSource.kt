package com.kenshi.favoritefeed.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kenshi.favoritefeed.data.model.UserInfo
import com.kenshi.favoritefeed.data.util.Constants.PAGING_SIZE
import com.kenshi.favoritefeed.data.util.Constants.STARTING_PAGE_INDEX
import com.kenshi.favoritefeed.data.service.RandomUserService
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class RandomUserPagingSource(
    private val service: RandomUserService,
) : PagingSource<Int, UserInfo>() {

    // PagingDataAdapter.refresh() or LazyPagingItems.refresh() 와 같은 함수를 통해 수동으로 리프레시를 할 때 호출됨
    override fun getRefreshKey(state: PagingState<Int, UserInfo>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
//        }
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserInfo> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getRandomUserList(
                results = params.loadSize,
                inc = "name,email,picture",
                page = position,
            )
            val endOfPaginationReached = response.results.isEmpty()
            val data = response.results
            val nextKey = if (endOfPaginationReached) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / PAGING_SIZE)
            }
            LoadResult.Page(
                data = data,
                // prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                prevKey = null,
                nextKey = nextKey,
            )
        } catch (exception: IOException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        }
    }
}
