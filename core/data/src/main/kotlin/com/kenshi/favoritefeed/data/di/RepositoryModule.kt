package com.kenshi.favoritefeed.data.di

import com.kenshi.favoritefeed.data.repository.RandomUserRepositoryImpl
import com.kenshi.favoritefeed.domain.RandomUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRandomUserRepository(randomUserRepositoryImpl: RandomUserRepositoryImpl): RandomUserRepository
}
