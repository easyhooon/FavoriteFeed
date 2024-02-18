package com.leejihun.supergene.assignment.core.designsystem

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SupergeneTopAppBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.Black,
    containerColor: Color = Color.White,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(containerColor)
            .then(modifier),
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = titleRes),
                color = contentColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                fontStyle = FontStyle.Normal,
            )
        }
    }
}
