package com.kenshi.favoritefeed.feature.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kenshi.favoritefeed.core.designsystem.R

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = R.string.favorites_list_empty),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W400,
        )
    }
}
