package com.kenshi.favoritefeed.feature.favorites

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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenshi.favoritefeed.core.designsystem.component.FavoriteFeedTopAppBar
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import com.kenshi.favoritefeed.domain.entity.UserNameEntity
import com.kenshi.favoritefeed.domain.entity.UserPictureEntity
import com.kenshi.favoritefeed.core.designsystem.DevicePreview
import com.kenshi.favoritefeed.core.designsystem.R
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun FavoritesRoute(
    padding: PaddingValues,
    onShowSnackBar: (UserInfoEntity) -> Unit,
    viewModel: FavoritesViewModel = hiltViewModel(),
) {
    val favoritesUserList by viewModel.favoritesUserList.collectAsState(initial = emptyList())

    FavoritesScreen(
        padding = padding,
        favoritesUserList = favoritesUserList.toImmutableList(),
        deleteFavoritesUser = viewModel::deleteFavoritesUser,
        onShowSnackBar = onShowSnackBar,
    )
}

@Composable
internal fun FavoritesScreen(
    padding: PaddingValues,
    favoritesUserList: ImmutableList<UserInfoEntity>,
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
    FavoriteFeedTopAppBar(
        titleRes = R.string.favorites_title,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun FavoriteContent(
    favoritesUserList: ImmutableList<UserInfoEntity>,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    onShowSnackBar: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (favoritesUserList.isEmpty()) {
        EmptyScreen(modifier = Modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            items(
                items = favoritesUserList,
                key = { it.email },
            ) { userInfo ->
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
                isLiked = true,
            ),
        )
    }

    FavoritesScreen(
        padding = PaddingValues(0.dp),
        favoritesUserList = favoritesUsers.toImmutableList(),
        onShowSnackBar = { _ -> },
        deleteFavoritesUser = { _ -> },
    )
}
