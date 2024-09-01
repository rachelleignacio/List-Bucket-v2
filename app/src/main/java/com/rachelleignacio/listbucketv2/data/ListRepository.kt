package com.rachelleignacio.listbucketv2.data

import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.annotation.Single

interface ListRepository {
    suspend fun createList(name: String, order: Int)
    suspend fun renameList(listId: Long, newName: String)
}

@Single
internal class ListRepositoryImpl(private val listDao: ListDao) : ListRepository {
    override suspend fun createList(name: String, order: Int) {
        listDao.insert(ListEntity(name = name, order = order))
    }

    override suspend fun renameList(listId: Long, newName: String) {
        with(listDao) {
            getListWithItems(listId).firstOrNull()?.let { update(it.list.copy(name = newName)) }
        }
    }
}