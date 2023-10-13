package com.example.cleanarchitecture.data.datasource

import com.example.cleanarchitecture.data.models.DataModel

class DataSource {

       fun getData(): List<DataModel> {
        return mutableListOf(
            DataModel('s'),
            DataModel('i'),
            DataModel('s'),
            DataModel('i'),
        )
    }
}