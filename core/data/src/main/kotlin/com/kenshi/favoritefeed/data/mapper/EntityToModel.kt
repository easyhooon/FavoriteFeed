package com.kenshi.favoritefeed.data.mapper

import com.kenshi.favoritefeed.data.model.UserInfo
import com.kenshi.favoritefeed.data.model.UserName
import com.kenshi.favoritefeed.data.model.UserPicture
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import com.kenshi.favoritefeed.domain.entity.UserNameEntity
import com.kenshi.favoritefeed.domain.entity.UserPictureEntity

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
