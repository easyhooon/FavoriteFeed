package com.leejihun.supergene.assignment.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leejihun.supergene.assignment.core.designsystem.ComponentPreview
import com.leejihun.supergene.assignment.core.designsystem.component.NetworkImage
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity

@Suppress("unused")
@Composable
fun HomeCard(
    userInfo: UserInfoEntity,
    insertFavoritesUser: (UserInfoEntity) -> Unit,
    deleteFavoritesUser: (UserInfoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        NetworkImage(
            imageUrl = userInfo.picture.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .aspectRatio(0.85f)
                .clip(RoundedCornerShape(40.dp)),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${userInfo.name.title} ${userInfo.name.first} ${userInfo.name.last}",
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W600,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = userInfo.email,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W400,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LikeButton(
            userInfo = userInfo,
            insertFavoritesUser = insertFavoritesUser,
            deleteFavoritesUser = deleteFavoritesUser,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@ComponentPreview
@Composable
fun HomeCardPreview() {
    HomeCard(
        userInfo = UserInfoEntity(
            name = UserNameEntity("Ms.", "Lukas", "Novak"),
            email = "dennis.anderson@gmail.com",
            picture = UserPictureEntity("", "", ""),
            isLiked = true,
        ),
        insertFavoritesUser = { _ -> },
        deleteFavoritesUser = { _ -> },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .aspectRatio(0.85f)
            .clip(RoundedCornerShape(12.dp)),
    )
}
