package com.adrianczerwinski.topnbaplayers.data.repository

import androidx.paging.PagingData
import com.adrianczerwinski.topnbaplayers.domain.model.Hero
import com.adrianczerwinski.topnbaplayers.domain.repository.DataStoreOperations
import com.adrianczerwinski.topnbaplayers.domain.repository.LocalDataSource
import com.adrianczerwinski.topnbaplayers.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>>{
        return remote.searchHeroes(query)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

}