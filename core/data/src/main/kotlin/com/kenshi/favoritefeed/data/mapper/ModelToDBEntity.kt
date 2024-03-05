package com.kenshi.favoritefeed.data.mapper

import com.kenshi.favoritefeed.core.database.entity.UserInfoEntity
import com.kenshi.favoritefeed.core.database.entity.UserNameEntity
import com.kenshi.favoritefeed.core.database.entity.UserPictureEntity
import com.kenshi.favoritefeed.data.model.UserInfo
import com.kenshi.favoritefeed.data.model.UserName
import com.kenshi.favoritefeed.data.model.UserPicture

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
