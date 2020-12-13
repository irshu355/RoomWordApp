package com.github.irshulx.roomwordapp.retrofit

import retrofit2.http.GET

interface BlogRetrofit {
    @GET("blogs")
    suspend fun getBlogs(): List<BlogNetworkEntity>
}