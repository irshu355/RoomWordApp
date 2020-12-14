package com.github.irshulx.roomwordapp.DI

import android.content.Context
import androidx.room.Room
import com.github.irshulx.roomwordapp.room.BlogDAO
import com.github.irshulx.roomwordapp.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideBlogDB(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(context, BlogDatabase::class.java,BlogDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDAO{
        return blogDatabase.blogDAO()
    }
}