package com.leejihun.supergene.assignment.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.leejihun.supergene.assignment.core.designsystem.R
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity

@Composable
fun LikeButton(
    userInfo: UserInfoEntity,
    insertFavoritesUser: (UserInfoEntity) -> Unit,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Black)
            .clickable { insertFavoritesUser(userInfo) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_favorite_outlined),
                contentDescription = "Like Button",
                tint = Color.Unspecified,
            )
        }
    }
}
