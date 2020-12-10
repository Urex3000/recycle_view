package com.example.recycle_view

import com.google.gson.annotations.SerializedName

class BookinfoClass {
    @SerializedName("title")
    public var title: String? = null
    public var description: String? = null
    public var author: String? = null

    @SerializedName("smallThumbnail")
    val imageResource: Int? = null
}