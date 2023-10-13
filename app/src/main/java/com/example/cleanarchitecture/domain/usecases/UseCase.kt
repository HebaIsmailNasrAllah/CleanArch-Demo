package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.IRepo
import com.example.cleanarchitecture.domain.models.DomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCase (val repo: IRepo){
//Can remove flow
    suspend fun getPhoneData(): Flow<DomainModel> {
        return flow {
            repo.getData().collect{
                    emit(it)
            }

        }
    }
}