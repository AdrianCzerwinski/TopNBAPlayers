package com.adrianczerwinski.borutoapp.domain.use_cases

import com.adrianczerwinski.borutoapp.data.paging_source.SearchHeroesSource
import com.adrianczerwinski.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardinfUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardinfUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)
