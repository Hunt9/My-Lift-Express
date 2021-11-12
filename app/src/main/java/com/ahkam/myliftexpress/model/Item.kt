package com.ahkam.myliftexpress.model


import java.io.Serializable

class Item : Serializable {
    var id: Int? = null
    var category: String? = null
    var description: String? = null
    var title: String? = null
    var price: Double? = null
    var image: String? = null
    var rating: Rating? = null
    var quantity: Int = 0

    inner class Rating : Serializable {
        var rate: Double? = null
        var count: Int? = null
    }

}