package com.leejihun.supergene.assignment.feature.home

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.leejihun.supergene.assignment.core.designsystem.R
import com.leejihun.supergene.assignment.core.designsystem.component.SupergeneTopAppBar
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity
import kotlinx.coroutines.flow.MutableStateFlow

@Suppress("unused")
@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val randomUserList = viewModel.randomUserList.collectAsLazyPagingItems()

    HomeScreen(
        padding = padding,
        randomUserList = randomUserList,
    )
}

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    randomUserList: LazyPagingItems<UserInfoEntity>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeTopAppBar(modifier = Modifier.statusBarsPadding())
        Box(modifier = Modifier.fillMaxSize()) {
            HomeContent(randomUserList = randomUserList)
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

@Composable
internal fun HomeContent(
    randomUserList: LazyPagingItems<UserInfoEntity>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(
            count = randomUserList.itemCount,
            key = randomUserList.itemKey(key = { user -> user.email }),
            contentType = randomUserList.itemContentType(),
        ) { index ->
            randomUserList[index]?.let { user ->
                HomeCard(
                    imageUrl = user.picture.large,
                    name = "${user.name.title} ${user.name.first} ${user.name.last}",
                    email = user.email,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    val randomUsers = mutableListOf<UserInfoEntity>()
    for (i in 1..5) {
        randomUsers.add(
            UserInfoEntity(
                name = UserNameEntity("Mrs", "Sheryl", "Alvarez"),
                email = "sheryl.alvarez${i}@example.com",
                picture = UserPictureEntity("", "", ""),
            ),
        )
    }
    val randomUserList = MutableStateFlow(PagingData.from(randomUsers)).collectAsLazyPagingItems()

    HomeScreen(
        padding = PaddingValues(0.dp),
        randomUserList = randomUserList,
    )
}

