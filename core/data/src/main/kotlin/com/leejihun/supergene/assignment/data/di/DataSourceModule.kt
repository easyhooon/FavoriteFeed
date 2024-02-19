package com.leejihun.supergene.assignment.data.di

import com.leejihun.supergene.assignment.data.datasource.RandomUserDataSource
import com.leejihun.supergene.assignment.data.datasource.RandomUserDataSourceImpl
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
}
