package com.leejihun.supergene.assignment.data.mapper

import com.leejihun.supergene.assignment.data.model.Info
import com.leejihun.supergene.assignment.data.model.RandomUserResponse
import com.leejihun.supergene.assignment.data.model.UserInfo
import com.leejihun.supergene.assignment.data.model.UserName
import com.leejihun.supergene.assignment.data.model.UserPicture
import com.leejihun.supergene.assignment.domain.entity.InfoEntity
import com.leejihun.supergene.assignment.domain.entity.RandomUserEntity
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import com.leejihun.supergene.assignment.domain.entity.UserNameEntity
import com.leejihun.supergene.assignment.domain.entity.UserPictureEntity

internal fun RandomUserResponse.toEntity(): RandomUserEntity {
    return RandomUserEntity(
        results = results.map { it.toEntity() },
        info = info.toEntity(),
    )
}

internal fun UserInfo.toEntity(): UserInfoEntity {
    return UserInfoEntity(
        name = name.toEntity(),
        email = email,
        picture = picture.toEntity(),
        isLiked = isLiked,
    )
}

internal fun UserInfoEntity.toModel(): UserInfo {
    return UserInfo(
        name = name.toModel(),
        email = email,
        picture = picture.toModel(),
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

internal fun UserNameEntity.toModel(): UserName {
    return UserName(
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

internal fun UserPictureEntity.toModel(): UserPicture {
    return UserPicture(
        large = large,
        medium = medium,
        thumbnail = thumbnail,
    )
}

internal fun Info.toEntity(): InfoEntity {
    return InfoEntity(
        seed = seed,
        results = results,
        page = page,
        version = version,
    )
}
