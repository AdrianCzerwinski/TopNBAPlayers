package com.adrianczerwinski.topnbaplayers.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.adrianczerwinski.topnbaplayers.data.repository.Repository
import com.adrianczerwinski.topnbaplayers.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}