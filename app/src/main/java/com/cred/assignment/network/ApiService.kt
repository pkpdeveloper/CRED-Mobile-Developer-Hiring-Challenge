package com.cred.assignment.network

import com.cred.assignment.network.response.Song
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {

    @GET("studio")
    fun getData(): Single<List<Song>>
}