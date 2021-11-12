package com.ahkam.myliftexpress.presentation.di.core

import com.ahkam.myliftexpress.data.api.SOService
import com.ahkam.myliftexpress.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.myliftexpress.data.repository.item.datasourceimpl.ItemRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (){

    @Singleton
    @Provides
    fun provideItemRemoteDataSource(soService: SOService) : ItemRemoteDataSource {

        return ItemRemoteDataSourceImpl(soService)
    }



}