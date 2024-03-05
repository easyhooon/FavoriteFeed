package com.kenshi.favoritefeed.data.mapper

import com.kenshi.favoritefeed.data.model.UserInfo
import com.kenshi.favoritefeed.data.model.UserName
import com.kenshi.favoritefeed.data.model.UserPicture
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import com.kenshi.favoritefeed.domain.entity.UserNameEntity
import com.kenshi.favoritefeed.domain.entity.UserPictureEntity

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
