package com.ahkam.myliftexpress.presentation.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ahkam.myliftexpress.domain.usecase.GetItemsUseCase

class ItemViewModel(
        private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    fun getItems() = liveData {
        val itemsList = getItemsUseCase.execute()
        emit(itemsList)
    }
}