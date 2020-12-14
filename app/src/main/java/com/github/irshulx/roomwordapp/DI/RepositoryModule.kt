package com.github.irshulx.roomwordapp.DI

import com.github.irshulx.roomwordapp.repository.MainRepository
import com.github.irshulx.roomwordapp.retrofit.BlogRetrofit
import com.github.irshulx.roomwordapp.retrofit.NetworkMapper
import com.github.irshulx.roomwordapp.room.BlogDAO
import com.github.irshulx.roomwordapp.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(blogRetrofit: BlogRetrofit,blogDAO: BlogDAO,cacheMapper: CacheMapper, networkMapper: NetworkMapper): MainRepository {
        return MainRepository(blogRetrofit,blogDAO,cacheMapper,networkMapper)
    }
}