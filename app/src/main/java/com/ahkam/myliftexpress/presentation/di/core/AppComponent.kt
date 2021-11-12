package com.ahkam.myliftexpress.presentation.di.core

import com.ahkam.myliftexpress.presentation.di.item.ItemSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun itemSubComponent(): ItemSubComponent.Factory

}