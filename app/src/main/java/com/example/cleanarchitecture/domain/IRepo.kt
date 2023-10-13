package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.domain.models.DomainModel
import kotlinx.coroutines.flow.Flow

interface IRepo {
    suspend fun getData(): Flow<DomainModel>
}