package com.kenshi.favoritefeed.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kenshi.favoritefeed.core.database.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

// DAO: Data Access Object, 데이터에 접근할 수 있는 메서드를 정의해놓은 인터페이스
@Dao
interface FavoritesUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritesUser(userInfo: UserInfoEntity)

    @Delete
    suspend fun deleteFavoritesUser(userInfo: UserInfoEntity)

    @Query("SELECT * FROM favorites_user")
    fun getFavoritesUserList(): Flow<List<UserInfoEntity>>

    @Query("UPDATE favorites_user SET is_liked = :isLiked WHERE email = :email")
    suspend fun updateFavoritesUser(email: String, isLiked: Boolean)
}
