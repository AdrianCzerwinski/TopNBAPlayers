package com.adrianczerwinski.topnbaplayers.data.repository

import com.adrianczerwinski.topnbaplayers.data.local.NBAHeroesDatabase
import com.adrianczerwinski.topnbaplayers.domain.model.Hero
import com.adrianczerwinski.topnbaplayers.domain.repository.LocalDataSource

class LocalDataSourceImpl(NBAHeroesDatabase: NBAHeroesDatabase): LocalDataSource {

    private val heroDao = NBAHeroesDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}