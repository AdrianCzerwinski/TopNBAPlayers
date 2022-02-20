package com.adrianczerwinski.topnbaplayers.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adrianczerwinski.topnbaplayers.util.Constants.HERO_REMOTE_KEYS_DB_TABLE

@Entity(tableName = HERO_REMOTE_KEYS_DB_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)

