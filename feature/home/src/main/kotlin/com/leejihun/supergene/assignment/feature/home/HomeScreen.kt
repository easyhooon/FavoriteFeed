package com.leejihun.supergene.assignment.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.leejihun.supergene.assignment.core.designsystem.DevicePreview
import com.leejihun.supergene.assignment.core.designsystem.R
import com.leejihun.supergene.assignment.core.designsystem.component.SupergeneTopAppBar
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity
import com.leejihun.supergene.assignment.feature.home.component.HomeCard
import com.leejihun.supergene.assignment.feature.home.component.LoadStateFooter
import com.leejihun.supergene.assignment.feature.home.component.LoadingIndicator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val randomUserList = viewModel.randomUserList.collectAsLazyPagingItems()

    HomeScreen(
        padding = padding,
        randomUserList = randomUserList,
        insertFavoritesUser = viewModel::insertFavoritesUser,
        deleteFavoritesUser = viewModel::deleteFavoritesUser,
    )
}

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    randomUserList: LazyPagingItems<UserInfoEntity>,
    insertFavoritesUser: (UserInfoEntity) -> Unit,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeTopAppBar(modifier = Modifier.statusBarsPadding())
        Box(modifier = Modifier.fillMaxSize()) {
            HomeContent(
                randomUserList = randomUserList,
                insertFavoritesUser = insertFavoritesUser,
                deleteFavoritesUser = deleteFavoritesUser,
            )
        }
    }
}

@Composable
internal fun HomeTopAppBar(
    modifier: Modifier = Modifier,
) {
    SupergeneTopAppBar(
        titleRes = R.string.home_title,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeContent(
    randomUserList: LazyPagingItems<UserInfoEntity>,
    insertFavoritesUser: (UserInfoEntity) -> Unit,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pullToRefreshState = rememberPullToRefreshState()
    val lazyListState = rememberLazyListState()

    val isFirstLoading = randomUserList.loadState.refresh is LoadState.Loading && randomUserList.itemCount == 0
    val isError = randomUserList.loadState.refresh is LoadState.Error

    LaunchedEffect(key1 = pullToRefreshState.isRefreshing) {
        if (pullToRefreshState.isRefreshing) {
            Timber.d("pullToRefresh 실행")
            delay(1000)
            randomUserList.refresh()
            pullToRefreshState.endRefresh()
        }
    }

    when {
        isFirstLoading -> LoadingIndicator(modifier = Modifier.fillMaxSize())
        isError -> ErrorScreen(onClickRetryButton = { randomUserList.retry() })
        else -> {
            Box(modifier = Modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)) {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    state = lazyListState,
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                ) {
                    items(
                        count = randomUserList.itemCount,
                        key = randomUserList.itemKey(key = { user -> user.email }),
                        contentType = randomUserList.itemContentType(),
                    ) { index ->
                        randomUserList[index]?.let { userInfo ->
                            HomeCard(
                                userInfo = userInfo,
                                insertFavoritesUser = insertFavoritesUser,
                                deleteFavoritesUser = deleteFavoritesUser,
                            )
                        }
                    }

                    item {
                        LoadStateFooter(
                            loadState = randomUserList.loadState.append,
                            onRetryClick = { randomUserList.retry() },
                            itemCount = randomUserList.itemCount,
                        )
                    }
                }
                if (pullToRefreshState.isRefreshing) {
                    PullToRefreshContainer(
                        modifier = Modifier.align(Alignment.TopCenter),
                        state = pullToRefreshState,
                    )
                }
            }
        }
    }
}

@DevicePreview
@Composable
internal fun HomeScreenPreview() {
    val randomUsers = mutableListOf<UserInfoEntity>()
    for (i in 1..5) {
        randomUsers.add(
            UserInfoEntity(
                name = UserNameEntity("Mrs", "Sheryl", "Alvarez"),
                email = "sheryl.alvarez@example.com$i",
                picture = UserPictureEntity("", "", ""),
            ),
        )
    }
    val randomUserList = MutableStateFlow(PagingData.from(randomUsers)).collectAsLazyPagingItems()

    HomeScreen(
        padding = PaddingValues(0.dp),
        randomUserList = randomUserList,
        insertFavoritesUser = { _ -> },
        deleteFavoritesUser = { _ -> },
    )
}
