package com.adrianczerwinski.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adrianczerwinski.borutoapp.data.local.dao.HeroDao
import com.adrianczerwinski.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.adrianczerwinski.borutoapp.domain.model.Hero
import com.adrianczerwinski.borutoapp.domain.model.HeroRemoteKey


@TypeConverters(DatabaseConverter::class )
@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}