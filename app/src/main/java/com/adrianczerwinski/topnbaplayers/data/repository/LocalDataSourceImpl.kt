package com.adrianczerwinski.topnbaplayers.data.repository

import com.adrianczerwinski.topnbaplayers.data.local.BorutoDatabase
import com.adrianczerwinski.topnbaplayers.domain.model.Hero
import com.adrianczerwinski.topnbaplayers.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}