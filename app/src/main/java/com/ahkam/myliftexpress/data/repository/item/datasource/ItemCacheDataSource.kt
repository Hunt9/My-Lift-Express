package com.ahkam.myliftexpress.data.repository.item.datasource

import com.ahkam.myliftexpress.model.Item


interface ItemCacheDataSource {
    suspend fun getItemsFromCache():List<Item>
    suspend fun saveItemsFromCache(item: List<Item>)
}