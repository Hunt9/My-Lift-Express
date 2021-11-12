package com.ahkam.myliftexpress.data.repository.item.datasourceimpl

import com.ahkam.myliftexpress.data.api.SOService
import com.ahkam.myliftexpress.model.Item
import com.ahkam.myliftexpress.data.repository.item.datasource.ItemRemoteDataSource
import retrofit2.Response

class ItemRemoteDataSourceImpl(private val soService: SOService):
    ItemRemoteDataSource {
    override suspend fun getItems(): Response<List<Item>> = soService.getItemList()

}