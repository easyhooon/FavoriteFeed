/*
 * Designed and developed by Wedemy 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/Wedemy/eggeum-android/blob/main/LICENSE
 */

package com.leejihun.supergene.assignment.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leejihun.supergene.assignment.data.model.UserInfo

// DAO: Data Access Object, 데이터에 접근할 수 있는 메서드를 정의해놓은 인터페이스
@Dao
interface FavoritesUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritesUser(userInfo: UserInfo)

    @Delete
    suspend fun deleteFavoritesUser(userInfo: UserInfo)

    @Query("SELECT * FROM favorites_user")
    fun getFavoritesUserList(): PagingSource<Int, UserInfo>
}
