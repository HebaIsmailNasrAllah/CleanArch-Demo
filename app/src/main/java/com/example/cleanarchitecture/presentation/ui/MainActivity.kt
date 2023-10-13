package com.example.cleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.data.datasource.DataSource
import com.example.cleanarchitecture.data.MobilesRepoImpl
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.usecases.UseCase
import com.example.cleanarchitecture.presentation.viewmodels.MobilesViewModel
import com.example.cleanarchitecture.presentation.viewmodels.MobileVMFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MobilesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = MobileVMFactory(UseCase(MobilesRepoImpl(DataSource())))
        viewModel = ViewModelProvider(this,factory).get(MobilesViewModel::class.java)
        lifecycleScope.launch {
            viewModel.data.collect{
                binding.imgMobile.setImageResource(it.resource)
            }
        }
    }
}