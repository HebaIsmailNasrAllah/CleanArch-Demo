package com.example.cleanarchitecture.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.presentation.models.toUIModel
import com.example.cleanarchitecture.domain.usecases.UseCase
import com.example.cleanarchitecture.presentation.models.UIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MobilesViewModel(private val useCase: UseCase): ViewModel() {
    private val _data : MutableStateFlow<UIModel> = MutableStateFlow(UIModel(0))
    val data : StateFlow<UIModel>
        get() = _data

    init {
        gainData()
    }
    fun gainData (){
        viewModelScope.launch {
            useCase.getPhoneData().collect{
                _data.emit(it.toUIModel())
            }
        }
    }
}

class MobileVMFactory(private val useCase: UseCase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MobilesViewModel::class.java)){
            return MobilesViewModel(useCase) as T
        }else{
            throw java.lang.IllegalArgumentException("No ViewModel with the provided data")
        }
    }
}