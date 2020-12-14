package com.github.irshulx.roomwordapp.repository

import com.github.irshulx.roomwordapp.model.Blog
import com.github.irshulx.roomwordapp.retrofit.BlogRetrofit
import com.github.irshulx.roomwordapp.retrofit.NetworkMapper
import com.github.irshulx.roomwordapp.room.BlogDAO
import com.github.irshulx.roomwordapp.room.CacheMapper
import com.github.irshulx.roomwordapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository constructor(private val blogRetrofit: BlogRetrofit,
                                         private val blogDAO: BlogDAO,
                                         private val cacheMapper: CacheMapper,
                                 private val networkMapper: NetworkMapper
                                         ) {
    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try{
            val networkBlogs = blogRetrofit.getBlogs()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for(blog in blogs) {
                blogDAO.insertBlog(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDAO.getBlogs()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        }catch (ex:Exception){
            emit(DataState.Error(ex))
        }
    }
}