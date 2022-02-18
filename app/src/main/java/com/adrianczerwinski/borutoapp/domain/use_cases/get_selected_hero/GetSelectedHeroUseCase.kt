package com.adrianczerwinski.borutoapp.domain.use_cases.get_selected_hero

import com.adrianczerwinski.borutoapp.data.repository.Repository
import com.adrianczerwinski.borutoapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}