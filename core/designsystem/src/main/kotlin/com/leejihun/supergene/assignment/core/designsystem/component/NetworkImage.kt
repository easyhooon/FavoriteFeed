package com.leejihun.supergene.assignment.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leejihun.supergene.assignment.core.designsystem.ComponentPreview

@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    if (LocalInspectionMode.current) {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = "HomeCard Image",
            modifier = modifier,
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
}

@ComponentPreview
@Composable
fun NetworkImagePreview() {
    NetworkImage(imageUrl = "")
}
