package com.raul.androidapps.testapplication.ui.main

import androidx.lifecycle.ViewModel
import com.raul.androidapps.testapplication.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: Repository) : ViewModel() {

    private var viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun getFoo() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFoo()
        }
    }
}
