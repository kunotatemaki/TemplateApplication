package com.raul.androidapps.testapplication.databinding

import androidx.databinding.DataBindingComponent
import javax.inject.Inject

class BindingComponent @Inject constructor(private val bindingAdapters: BindingAdapters) :
    DataBindingComponent {
    override fun getBindingAdapters(): BindingAdapters {
        return bindingAdapters
    }
}