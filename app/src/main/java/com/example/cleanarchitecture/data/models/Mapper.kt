package com.example.cleanarchitecture.data.models

import com.example.cleanarchitecture.domain.models.DomainModel
import com.example.cleanarchitecture.domain.models.MobileTypes

fun DataModel.toDomainModel(): DomainModel {
    return if(this.firstCharacter == 's'){
        DomainModel(MobileTypes.SAMSUNG, "GalaxyS", 1234)
    }else{
        DomainModel(MobileTypes.IPHONE, "iPhone", 1234)
    }
}