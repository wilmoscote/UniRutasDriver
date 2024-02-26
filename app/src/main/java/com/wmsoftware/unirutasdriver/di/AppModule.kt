package com.wmsoftware.unirutasdriver.di

import android.content.Context
import com.wmsoftware.unirutasdriver.data.datasource.local.UserPreferences
import com.wmsoftware.unirutasdriver.network.service.LocationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserPreferences(@ApplicationContext context: Context): UserPreferences {
        return UserPreferences(context)
    }

    @Provides
    @Singleton
    fun provideLocationService(@ApplicationContext context: Context): LocationService {
        return LocationService(context)
    }
}