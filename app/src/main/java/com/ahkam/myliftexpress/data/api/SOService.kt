package com.ahkam.myliftexpress.data.api

import com.ahkam.myliftexpress.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface SOService {

    @GET("/products")
    suspend fun getItemList():Response<List<Item>>

}