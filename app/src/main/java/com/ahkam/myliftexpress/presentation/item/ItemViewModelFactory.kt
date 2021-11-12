package com.ahkam.myliftexpress.presentation.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahkam.myliftexpress.domain.usecase.GetItemsUseCase

class ItemViewModelFactory(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(getItemsUseCase) as T
    }
}