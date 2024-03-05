package com.kenshi.favoritefeed.data.di

import com.kenshi.favoritefeed.data.datasource.FavoritesUserDataSource
import com.kenshi.favoritefeed.data.datasource.FavoritesUserDataSourceImpl
import com.kenshi.favoritefeed.data.datasource.RandomUserDataSource
import com.kenshi.favoritefeed.data.datasource.RandomUserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindRandomUserDataSource(randomUserDataSourceImpl: RandomUserDataSourceImpl): RandomUserDataSource

    @Singleton
    @Binds
    abstract fun bindFavoritesUserDataSource(favoritesUserDataSourceImpl: FavoritesUserDataSourceImpl): FavoritesUserDataSource
}
