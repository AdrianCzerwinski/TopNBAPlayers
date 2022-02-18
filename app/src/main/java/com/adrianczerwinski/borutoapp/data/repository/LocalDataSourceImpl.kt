package com.adrianczerwinski.borutoapp.data.repository

import com.adrianczerwinski.borutoapp.data.local.BorutoDatabase
import com.adrianczerwinski.borutoapp.domain.model.Hero
import com.adrianczerwinski.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}