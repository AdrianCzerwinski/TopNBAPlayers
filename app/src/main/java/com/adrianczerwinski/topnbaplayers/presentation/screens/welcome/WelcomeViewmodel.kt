package com.adrianczerwinski.topnbaplayers.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrianczerwinski.topnbaplayers.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WelcomeViewmodel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    fun saveOnBoardingState(completed: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase(completed = completed)
        }
    }
}