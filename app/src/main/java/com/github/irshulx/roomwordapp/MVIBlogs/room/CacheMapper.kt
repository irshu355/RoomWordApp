package com.github.irshulx.roomwordapp.MVIBlogs.room

import com.github.irshulx.roomwordapp.MVIBlogs.model.Blog
import com.github.irshulx.roomwordapp.MVIBlogs.utils.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor(): EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(entity.id,entity.title,entity.image,entity.category,entity.body)
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(domainModel.id,domainModel.title,domainModel.body,domainModel.image, domainModel.category)
    }

    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog> {
        return entities.map { mapFromEntity(it) }
    }

}