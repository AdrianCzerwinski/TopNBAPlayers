package com.adrianczerwinski.borutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.adrianczerwinski.borutoapp.data.repository.Repository
import com.adrianczerwinski.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>>{
        return repository.searchHeroes(query = query)
    }
}