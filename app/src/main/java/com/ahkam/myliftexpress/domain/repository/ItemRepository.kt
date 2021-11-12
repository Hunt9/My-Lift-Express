package com.ahkam.myliftexpress.domain.repository

import com.ahkam.myliftexpress.model.Item

interface ItemRepository {

    suspend fun getItems():List<Item>?
}