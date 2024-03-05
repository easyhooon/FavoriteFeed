package com.kenshi.favoritefeed.domain.entity

import androidx.compose.runtime.Stable

@Stable
data class RandomUserEntity(
    val results: List<UserInfoEntity>,
    val info: InfoEntity,
)

@Stable
data class UserInfoEntity(
    val name: UserNameEntity,
    val email: String,
    val picture: UserPictureEntity,
    val isLiked: Boolean,
)

@Stable
data class UserNameEntity(
    val title: String,
    val first: String,
    val last: String,
)

@Stable
data class UserPictureEntity(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

@Stable
data class InfoEntity(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String,
)
