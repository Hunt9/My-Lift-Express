package com.ahkam.myliftexpress.domain.usecase

import com.ahkam.myliftexpress.domain.repository.ItemRepository
import com.ahkam.myliftexpress.model.Item

class GetItemsUseCase(private val itemRepository: ItemRepository) {

    suspend fun execute():List<Item>?=itemRepository.getItems()
}