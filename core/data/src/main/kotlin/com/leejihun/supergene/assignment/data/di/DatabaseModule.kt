package com.leejihun.supergene.assignment.data.di

import android.content.Context
import androidx.room.Room
import com.leejihun.supergene.assignment.data.database.FavoritesUserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideFavoritesUserDatabase(@ApplicationContext context: Context): FavoritesUserDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            FavoritesUserDatabase::class.java,
            "favorites_user_database",
        ).build()
}
