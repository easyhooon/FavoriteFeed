/*
 * Designed and developed by Wedemy 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/Wedemy/eggeum-android/blob/main/LICENSE
 */

package com.leejihun.supergene.assignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leejihun.supergene.assignment.data.model.UserInfo

@Database(
    entities = [UserInfo::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(OrmConverter::class)
abstract class FavoritesUserDatabase : RoomDatabase() {
    abstract fun favoritesUserDao(): FavoritesUserDao
}
