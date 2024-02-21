package com.leejihun.supergene.assignment.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.leejihun.supergene.assignment.core.designsystem.ComponentPreview
import com.leejihun.supergene.assignment.core.designsystem.R
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity

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
            .background(if (userInfo.isLiked) Color.White else Color.Black)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp),
            )
            .clickable {
                if (userInfo.isLiked) deleteFavoritesUser(userInfo)
                else insertFavoritesUser(userInfo)
            },
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
                imageVector = if (userInfo.isLiked) ImageVector.vectorResource(R.drawable.ic_favorite_filled_red)
                else ImageVector.vectorResource(R.drawable.ic_favorite_outlined_white),
                contentDescription = "Like Button",
                tint = Color.Unspecified,
            )
        }
    }
}

@ComponentPreview
@Composable
fun LikeButtonPreview() {
    LikeButton(
        userInfo = UserInfoEntity(
            name = UserNameEntity("Mrs", "Sheryl", "Alvarez"),
            email = "sheryl.alvarez@example.com",
            picture = UserPictureEntity("", "", ""),
            isLiked = false,
        ),
        insertFavoritesUser = { _ -> },
        deleteFavoritesUser = { _ -> },
    )
}

@ComponentPreview
@Composable
fun LikeButtonCheckedPreview() {
    LikeButton(
        userInfo = UserInfoEntity(
            name = UserNameEntity("Mrs", "Sheryl", "Alvarez"),
            email = "sheryl.alvarez@example.com",
            picture = UserPictureEntity("", "", ""),
            isLiked = true,
        ),
        insertFavoritesUser = { _ -> },
        deleteFavoritesUser = { _ -> },
    )
}
