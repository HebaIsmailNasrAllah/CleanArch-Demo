package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.datasource.DataSource
import com.example.cleanarchitecture.data.models.toDomainModel
import com.example.cleanarchitecture.domain.models.DomainModel
import com.example.cleanarchitecture.domain.IRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MobilesRepoImpl(val dataSource: DataSource) : IRepo{
    override suspend fun getData(): Flow<DomainModel> {
        val mList = mutableListOf<DomainModel>()
        for (i in dataSource.getData())
            mList.add(i.toDomainModel())
        return flow{
            for (i in mList){
                delay(1000)
                emit(i)
            }
        }
    }

}