package com.leejihun.supergene.assignment.domain.entity

data class RandomUserEntity(
    val results: List<UserInfoEntity>,
    val info: InfoEntity,
)

data class UserInfoEntity(
    val name: UserNameEntity,
    val email: String,
    val picture: UserPictureEntity,
)

data class UserNameEntity(
    val title: String,
    val first: String,
    val last: String,
)

data class UserPictureEntity(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

data class InfoEntity(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String,
)
