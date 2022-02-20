package com.adrianczerwinski.topnbaplayers.domain.use_cases.save_onboarding

import com.adrianczerwinski.topnbaplayers.data.repository.Repository

class SaveOnBoardinfUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}