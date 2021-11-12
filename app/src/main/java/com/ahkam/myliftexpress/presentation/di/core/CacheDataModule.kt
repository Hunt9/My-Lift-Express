package com.ahkam.myliftexpress.presentation.di.core

import com.ahkam.myliftexpress.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.myliftexpress.data.repository.item.datasourceimpl.ItemCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideItemCacheDataSource(): ItemCacheDataSource {
        return ItemCacheDataSourceImpl()
    }

}