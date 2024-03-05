/*
 * Designed and developed by Wedemy 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/Wedemy/eggeum-android/blob/main/LICENSE
 */

package com.kenshi.favoritefeed.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kenshi.favoritefeed.core.database.entity.UserInfoEntity

@Database(
    entities = [UserInfoEntity::class],
    version = 1,
    exportSchema = true,
)
@TypeConverters(OrmConverter::class)
abstract class FavoritesUserDatabase : RoomDatabase() {
    abstract fun favoritesUserDao(): FavoritesUserDao
}
