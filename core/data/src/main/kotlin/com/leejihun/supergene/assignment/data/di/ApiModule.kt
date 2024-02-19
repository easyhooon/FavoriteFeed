package com.leejihun.supergene.assignment.data.di

import com.leejihun.supergene.assignment.data.service.RandomUserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Singleton
    @Provides
    internal fun provideRandomUserService(
        retrofit: Retrofit,
    ): RandomUserService {
        return retrofit.create(RandomUserService::class.java)
    }
}
