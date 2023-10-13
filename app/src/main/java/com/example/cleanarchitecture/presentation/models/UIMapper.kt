package com.example.cleanarchitecture.presentation.models

import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.domain.models.DomainModel
import com.example.cleanarchitecture.domain.models.MobileTypes

fun DomainModel.toUIModel():UIModel{
    return if(this.phoneType == MobileTypes.SAMSUNG){
        UIModel(R.drawable.samsung)
    }else{
        UIModel(R.drawable.iphone)
    }
}
