package com.cred.assignment.network.response

import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("song") val song: String,
    @SerializedName("url") val url: String,
    @SerializedName("artists") val artists: String,
    @SerializedName("cover_image") val cover_image: String
)
