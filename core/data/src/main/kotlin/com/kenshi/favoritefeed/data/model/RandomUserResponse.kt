package com.kenshi.favoritefeed.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserResponse(
    @SerialName("results")
    val results: List<UserInfo>,
    @SerialName("info")
    val info: Info,
)

@Serializable
data class UserInfo(
    @SerialName("name")
    val name: UserName,
    @SerialName("email")
    val email: String,
    @SerialName("picture")
    val picture: UserPicture,
    val isLiked: Boolean = false,
)

@Serializable
data class UserName(
    @SerialName("title")
    val title: String,
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String,
)

@Serializable
data class UserPicture(
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("thumbnail")
    val thumbnail: String,
)

@Serializable
data class Info(
    @SerialName("seed")
    val seed: String,
    @SerialName("results")
    val results: Int,
    @SerialName("page")
    val page: Int,
    @SerialName("version")
    val version: String,
)
