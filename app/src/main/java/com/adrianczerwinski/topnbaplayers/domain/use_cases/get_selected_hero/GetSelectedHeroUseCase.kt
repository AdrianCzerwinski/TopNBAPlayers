package com.adrianczerwinski.topnbaplayers.domain.use_cases.get_selected_hero

import com.adrianczerwinski.topnbaplayers.data.repository.Repository
import com.adrianczerwinski.topnbaplayers.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}