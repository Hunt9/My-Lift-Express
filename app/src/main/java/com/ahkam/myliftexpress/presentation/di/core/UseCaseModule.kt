package com.ahkam.myliftexpress.presentation.di.core

import com.ahkam.myliftexpress.domain.repository.ItemRepository
import com.ahkam.myliftexpress.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetItemUseCase(itemRepository: ItemRepository): GetItemsUseCase
    {
        return GetItemsUseCase(itemRepository)
    }


}