package com.leejihun.supergene.assignment.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "favorites_user")
data class UserInfoEntity(
    @PrimaryKey
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "name")
    val name: UserNameEntity,
    @ColumnInfo(name = "picture")
    val picture: UserPictureEntity,
    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean = false,
)

@Serializable
data class UserNameEntity(
    val title: String,
    val first: String,
    val last: String,
)

@Serializable
data class UserPictureEntity(
    val large: String,
    val medium: String,
    val thumbnail: String,
)
