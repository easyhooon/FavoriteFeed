package com.kenshi.favoritefeed.data.di

import com.kenshi.favoritefeed.data.service.RandomUserService
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
