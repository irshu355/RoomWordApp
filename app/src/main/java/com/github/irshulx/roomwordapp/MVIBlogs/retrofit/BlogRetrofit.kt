package com.github.irshulx.roomwordapp.MVIBlogs.retrofit

import retrofit2.http.GET

interface BlogRetrofit {
    @GET("blogs")
    suspend fun getBlogs(): List<BlogNetworkEntity>
}