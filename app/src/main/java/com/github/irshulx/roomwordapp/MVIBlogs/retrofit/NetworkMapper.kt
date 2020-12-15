package com.github.irshulx.roomwordapp.MVIBlogs.retrofit

import com.github.irshulx.roomwordapp.MVIBlogs.model.Blog
import com.github.irshulx.roomwordapp.MVIBlogs.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor(): EntityMapper<BlogNetworkEntity, Blog> {


    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(entity.id,entity.title,entity.image,entity.category,entity.body)
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(domainModel.id,domainModel.title,domainModel.body,domainModel.image, domainModel.category)
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog> {
        return entities.map { mapFromEntity(it) }
    }
}