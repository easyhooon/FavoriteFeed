package com.leejihun.supergene.assignment.data.mapper

import com.leejihun.supergene.assignment.core.database.entity.UserInfoEntity
import com.leejihun.supergene.assignment.core.database.entity.UserNameEntity
import com.leejihun.supergene.assignment.core.database.entity.UserPictureEntity
import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.model.UserName
import com.leejihun.supergene.assignment.data.model.UserPicture

internal fun UserInfo.toDBEntity(): UserInfoEntity {
    return UserInfoEntity(
        name = name.toDBEntity(),
        email = email,
        picture = picture.toDBEntity(),
        isLiked = isLiked,
    )
}

internal fun UserName.toDBEntity(): UserNameEntity {
    return UserNameEntity(
        title = title,
        first = first,
        last = last,
    )
}

internal fun UserPicture.toDBEntity(): UserPictureEntity {
    return UserPictureEntity(
        large = large,
        medium = medium,
        thumbnail = thumbnail,
    )
}
