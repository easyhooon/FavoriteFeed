package com.leejihun.supergene.assignment.data.di

import com.leejihun.supergene.assignment.data.database.FavoritesUserDao
import com.leejihun.supergene.assignment.data.database.FavoritesUserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun provideFavoritesUserDao(
        database: FavoritesUserDatabase,
    ): FavoritesUserDao = database.favoritesUserDao()
}
