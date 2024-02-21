package com.leejihun.supergene.assignment.data.mapper

import com.leejihun.supergene.assignment.core.database.entity.UserInfoEntity
import com.leejihun.supergene.assignment.core.database.entity.UserNameEntity
import com.leejihun.supergene.assignment.core.database.entity.UserPictureEntity
import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.model.UserName
import com.leejihun.supergene.assignment.data.model.UserPicture

internal fun UserInfoEntity.toModel(): UserInfo {
    return UserInfo(
        name = name.toModel(),
        email = email,
        picture = picture.toModel(),
        isLiked = isLiked,
    )
}

internal fun UserNameEntity.toModel(): UserName {
    return UserName(
        title = title,
        first = first,
        last = last,
    )
}

internal fun UserPictureEntity.toModel(): UserPicture {
    return UserPicture(
        large = large,
        medium = medium,
        thumbnail = thumbnail,
    )
}
