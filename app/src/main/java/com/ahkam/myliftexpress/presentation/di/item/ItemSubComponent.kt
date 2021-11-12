package com.ahkam.myliftexpress.presentation.di.item

import com.ahkam.myliftexpress.fragments.HomeFragment
import dagger.Subcomponent

@ItemScope
@Subcomponent(modules = [ItemModule::class])
interface ItemSubComponent {
    fun inject (homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ItemSubComponent
    }
}