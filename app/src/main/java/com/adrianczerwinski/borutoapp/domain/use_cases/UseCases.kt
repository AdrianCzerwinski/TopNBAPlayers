package com.adrianczerwinski.borutoapp.domain.use_cases

import com.adrianczerwinski.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardinfUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardinfUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
