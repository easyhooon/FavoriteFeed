package com.leejihun.supergene.assignment.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.leejihun.supergene.assignment.data.model.UserName
import com.leejihun.supergene.assignment.data.model.UserPicture

// ORM -> 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것
class OrmConverter {
    private val json = Json

    @TypeConverter
    fun fromUserName(userName: UserName?): String? {
        return userName?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toUserName(userNameString: String?): UserName? {
        return userNameString?.let { json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromUserPicture(userPicture: UserPicture?): String? {
        return userPicture?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toUserPicture(userPictureString: String?): UserPicture? {
        return userPictureString?.let { json.decodeFromString(it) }
    }
}
