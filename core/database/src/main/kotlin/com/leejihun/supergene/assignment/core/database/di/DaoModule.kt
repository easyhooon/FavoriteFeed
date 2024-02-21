package com.leejihun.supergene.assignment.core.database.di

import com.leejihun.supergene.assignment.core.database.FavoritesUserDao
import com.leejihun.supergene.assignment.core.database.FavoritesUserDatabase
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
