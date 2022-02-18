package com.adrianczerwinski.borutoapp.domain.repository

import com.adrianczerwinski.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}