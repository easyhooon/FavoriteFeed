package com.leejihun.supergene.assignment.feature.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leejihun.supergene.assignment.core.designsystem.R
import com.leejihun.supergene.assignment.core.designsystem.SupergeneTopAppBar

@Composable
internal fun FavoriteRoute(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel(),
) {
    HomeScreen(
        padding = padding,
    )
}

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FavoritesTopAppBar(modifier = Modifier.statusBarsPadding())
        Box(modifier = Modifier.fillMaxSize()) {
            HomeContent()
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

@Composable
internal fun HomeContent() {}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeScreen(
        PaddingValues(0.dp),
    )
}
