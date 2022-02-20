package com.adrianczerwinski.topnbaplayers.domain.repository

import com.adrianczerwinski.topnbaplayers.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}