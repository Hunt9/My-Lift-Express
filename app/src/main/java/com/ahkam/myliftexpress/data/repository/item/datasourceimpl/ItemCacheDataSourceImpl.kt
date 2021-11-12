package com.ahkam.myliftexpress.data.repository.item.datasourceimpl

import com.ahkam.myliftexpress.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.myliftexpress.model.Item

class ItemCacheDataSourceImpl : ItemCacheDataSource {
    private var itemsList = ArrayList<Item>()
    override suspend fun getItemsFromCache(): List<Item> {
        return itemsList
    }

    override suspend fun saveItemsFromCache(item: List<Item>) {
        itemsList.clear()
        itemsList = ArrayList(item)

    }
}