package com.leejihun.supergene.assignment.data.mapper

import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.model.UserName
import com.leejihun.supergene.assignment.data.model.UserPicture
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity

internal fun UserInfo.toEntity(): UserInfoEntity {
    return UserInfoEntity(
        name = name.toEntity(),
        email = email,
        picture = picture.toEntity(),
        isLiked = isLiked,
    )
}

internal fun UserName.toEntity(): UserNameEntity {
    return UserNameEntity(
        title = title,
        first = first,
        last = last,
    )
}

internal fun UserPicture.toEntity(): UserPictureEntity {
    return UserPictureEntity(
        large = large,
        medium = medium,
        thumbnail = thumbnail,
    )
}
