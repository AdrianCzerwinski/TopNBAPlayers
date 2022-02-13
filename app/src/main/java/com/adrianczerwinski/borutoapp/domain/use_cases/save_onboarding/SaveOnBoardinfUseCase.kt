package com.adrianczerwinski.borutoapp.domain.use_cases.save_onboarding

import com.adrianczerwinski.borutoapp.data.repository.Repository

class SaveOnBoardinfUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}