package com.kenshi.favoritefeed.core.database

import androidx.room.TypeConverter
import com.kenshi.favoritefeed.core.database.entity.UserNameEntity
import com.kenshi.favoritefeed.core.database.entity.UserPictureEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// ORM -> 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것
class OrmConverter {
    private val json = Json

    @TypeConverter
    fun fromUserName(userName: UserNameEntity?): String? {
        return userName?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toUserName(userNameString: String?): UserNameEntity? {
        return userNameString?.let { json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromUserPicture(userPicture: UserPictureEntity?): String? {
        return userPicture?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toUserPicture(userPictureString: String?): UserPictureEntity? {
        return userPictureString?.let { json.decodeFromString(it) }
    }
}
