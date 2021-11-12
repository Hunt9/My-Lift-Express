package com.ahkam.myliftexpress.presentation.di.core

import android.content.Context
import com.ahkam.myliftexpress.presentation.di.item.ItemSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ItemSubComponent::class])
class AppModule (private val context:Context){


    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }


}