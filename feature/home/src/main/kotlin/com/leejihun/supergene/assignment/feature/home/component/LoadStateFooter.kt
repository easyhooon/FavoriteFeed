package com.leejihun.supergene.assignment.feature.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.leejihun.supergene.assignment.core.designsystem.ComponentPreview

@Composable
fun LoadStateFooter(
    loadState: LoadState,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        when (loadState) {
            is LoadState.Loading -> LoadingIndicator()

            is LoadState.Error -> LoadErrorScreen(onRetryClick = onRetryClick)

            else -> EndOfResultScreen()
        }
    }
}

@ComponentPreview
@Composable
fun LoadStateFooterPreview() {
    LoadStateFooter(
        loadState = LoadState.Loading,
        onRetryClick = {},
    )
}
