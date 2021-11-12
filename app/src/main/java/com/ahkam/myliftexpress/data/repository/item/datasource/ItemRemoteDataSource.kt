package com.ahkam.myliftexpress.data.repository.item.datasource

import com.ahkam.myliftexpress.model.Item
import retrofit2.Response

interface ItemRemoteDataSource {
    suspend fun getItems(): Response<List<Item>>
}