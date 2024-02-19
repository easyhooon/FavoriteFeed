package com.leejihun.supergene.assignment.feature.favorites

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun FavoritesRoute(
    padding: PaddingValues,
    onShowSnackBar: (UserInfoEntity) -> Unit,
    viewModel: FavoritesViewModel = hiltViewModel(),
) {
    val favoritesUserList = viewModel.favoritesUserList.collectAsLazyPagingItems()

    FavoritesScreen(
        padding = padding,
        favoritesUserList = favoritesUserList,
        deleteFavoritesUser = viewModel::deleteFavoritesUser,
        onShowSnackBar = onShowSnackBar,
    )
}

@Composable
internal fun FavoritesScreen(
    padding: PaddingValues,
    favoritesUserList: LazyPagingItems<UserInfoEntity>,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    onShowSnackBar: (UserInfoEntity) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FavoritesTopAppBar(modifier = Modifier.statusBarsPadding())
        Box(modifier = Modifier.fillMaxSize()) {
            FavoriteContent(
                favoritesUserList = favoritesUserList,
                deleteFavoritesUser = deleteFavoritesUser,
                onShowSnackBar = onShowSnackBar,
            )
        }
    }
}

@Composable
internal fun FavoritesTopAppBar(
    modifier: Modifier = Modifier,
) {
    SupergeneTopAppBar(
        titleRes = R.string.favorites_title,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun FavoriteContent(
    favoritesUserList: LazyPagingItems<UserInfoEntity>,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    onShowSnackBar: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(
            count = favoritesUserList.itemCount,
            key = favoritesUserList.itemKey(key = { user -> user.email }),
            contentType = favoritesUserList.itemContentType(),
        ) { index ->
            favoritesUserList[index]?.let { userInfo ->
                FavoritesCard(
                    userInfo = userInfo,
                    deleteFavoritesUser = deleteFavoritesUser,
                    onShowSnackBar = onShowSnackBar,
                    modifier = Modifier.animateItemPlacement(
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing,
                        ),
                    ),
                )
            }
        }
    }
}

@DevicePreview
@Composable
internal fun FavoritesScreenPreview() {
    val favoritesUsers = mutableListOf<UserInfoEntity>()
    for (i in 1..5) {
        favoritesUsers.add(
            UserInfoEntity(
                name = UserNameEntity("Mrs", "Sheryl", "Alvarez"),
                email = "sheryl.alvarez@example.com$i",
                picture = UserPictureEntity("", "", ""),
            ),
        )
    }
    val favoritesUserList = MutableStateFlow(PagingData.from(favoritesUsers)).collectAsLazyPagingItems()

    FavoritesScreen(
        padding = PaddingValues(0.dp),
        favoritesUserList = favoritesUserList,
        onShowSnackBar = { _ -> },
        deleteFavoritesUser = { _ -> },
    )
}
