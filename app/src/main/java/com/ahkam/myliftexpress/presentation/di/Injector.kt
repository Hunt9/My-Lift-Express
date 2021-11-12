package com.ahkam.start.presentation.di


import com.ahkam.myliftexpress.presentation.di.item.ItemSubComponent

interface Injector {
    fun createItemSubComponent(): ItemSubComponent


}