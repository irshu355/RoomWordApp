package com.github.irshulx.roomwordapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blogEntity: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun getBlogs():List<BlogCacheEntity>
}