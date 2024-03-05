package com.kenshi.favoritefeed.feature.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.kenshi.favoritefeed.core.designsystem.ComponentPreview

@Composable
fun LoadStateFooter(
    loadState: LoadState,
    onRetryClick: () -> Unit,
    itemCount: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        when (loadState) {
            is LoadState.Loading -> LoadingIndicator(modifier.fillMaxWidth())

            is LoadState.Error -> LoadErrorScreen(onRetryClick = onRetryClick)

            is LoadState.NotLoading -> {
                if (loadState.endOfPaginationReached && itemCount > 0) {
                    EndOfResultScreen()
                }
            }
        }
    }
}

@ComponentPreview
@Composable
fun LoadStateFooterLoadingPreview() {
    LoadStateFooter(
        loadState = LoadState.Loading,
        onRetryClick = {},
        itemCount = 4,
    )
}

@ComponentPreview
@Composable
fun LoadStateFooterErrorPreview() {
    LoadStateFooter(
        loadState = LoadState.Error(Exception("Network Error")),
        onRetryClick = {},
        itemCount = 4,
    )
}

@ComponentPreview
@Composable
fun LoadStateFooterEndOfResultPreview() {
    LoadStateFooter(
        loadState = LoadState.NotLoading(true),
        onRetryClick = {},
        itemCount = 4,
    )
}
