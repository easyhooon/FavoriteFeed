package com.kenshi.favoritefeed.feature.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import com.kenshi.favoritefeed.domain.entity.UserNameEntity
import com.kenshi.favoritefeed.domain.entity.UserPictureEntity
import com.kenshi.favoritefeed.core.designsystem.ComponentPreview
import com.kenshi.favoritefeed.core.designsystem.R
import com.kenshi.favoritefeed.core.designsystem.component.NetworkImage

@Composable
fun FavoritesCard(
    userInfo: UserInfoEntity,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    onShowSnackBar: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier.padding(16.dp)) {
        NetworkImage(
            imageUrl = userInfo.picture.large,
            modifier = Modifier
                .size(width = 68.dp, height = 74.dp)
                .clip(RoundedCornerShape(20.dp)),
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "${userInfo.name.title} ${userInfo.name.first} ${userInfo.name.last}",
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.W600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = userInfo.email,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.W400,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = if (userInfo.isLiked) ImageVector.vectorResource(R.drawable.ic_favorite_filled_red)
                else ImageVector.vectorResource(R.drawable.ic_favorite_outlined_red),
                contentDescription = "Like Button",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        deleteFavoritesUser(userInfo)
                        onShowSnackBar(userInfo)
                    },
                tint = Color.Unspecified,
            )
        }
    }
}

@ComponentPreview
@Composable
fun FavoritesCardPreview() {
    FavoritesCard(
        userInfo = UserInfoEntity(
            name = UserNameEntity("Ms.", "Lukas", "Novak"),
            email = "dennis.anderson@gmail.com",
            picture = UserPictureEntity("", "", ""),
            isLiked = true,
        ),
        deleteFavoritesUser = { _ -> },
        onShowSnackBar = { _ -> },
        modifier = Modifier.size(width = 68.dp, height = 74.dp),
    )
}
