package com.ahkam.myliftexpress.presentation.di.item

import com.ahkam.myliftexpress.domain.usecase.GetItemsUseCase
import com.ahkam.myliftexpress.presentation.item.ItemViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ItemModule {

    @ItemScope
    @Provides
    fun provideItemViewModelFactory(
        getItemsUseCase: GetItemsUseCase
    ): ItemViewModelFactory {

        return ItemViewModelFactory(getItemsUseCase)
    }

}