package com.leejihun.supergene.assignment.feature.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leejihun.supergene.assignment.core.designsystem.ComponentPreview
import com.leejihun.supergene.assignment.core.designsystem.R

@Composable
fun FavoritesCard(
    imageUrl: String,
    name: String,
    email: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.padding(16.dp),
    ) {
        if (LocalInspectionMode.current) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "FavoritesCard Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(width = 68.dp, height = 74.dp)
                    .aspectRatio(1f),
            )
        } else {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "HomeCard Image",
                contentScale = ContentScale.Crop,
                modifier = modifier,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.W600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = email,
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
                imageVector = ImageVector.vectorResource(R.drawable.ic_favorite_checked),
                contentDescription = "Like Button",
                modifier = Modifier.padding(8.dp),
                tint = Color.Unspecified,
            )
        }
    }
}

@ComponentPreview
@Composable
fun FavoritesCardPreview() {
    FavoritesCard(
        imageUrl = "",
        name = "Ms. Lukas Novak",
        email = "dennis.anderson@gmail.com",
        modifier = Modifier.size(width = 68.dp, height = 74.dp),
    )
}
