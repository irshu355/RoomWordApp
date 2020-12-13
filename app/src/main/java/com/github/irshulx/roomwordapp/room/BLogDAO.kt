package com.github.irshulx.roomwordapp.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BLogDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blogEntity: BlogCacheEntity): Long

    @Query("select * from blogs")
    suspend fun getBlogs():List<BlogCacheEntity>
}