package com.leejihun.supergene.assignment.data.di

import com.leejihun.supergene.assignment.data.repository.RandomUserRepositoryImpl
import com.leejihun.supergene.assignment.domain.RandomUserRepository
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
