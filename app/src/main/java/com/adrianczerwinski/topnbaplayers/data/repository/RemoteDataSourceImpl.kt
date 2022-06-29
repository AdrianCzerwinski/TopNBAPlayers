package com.adrianczerwinski.topnbaplayers.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.adrianczerwinski.topnbaplayers.data.local.NBAHeroesDatabase
import com.adrianczerwinski.topnbaplayers.data.paging_source.HeroRemoteMediator
import com.adrianczerwinski.topnbaplayers.data.paging_source.SearchHeroesSource
import com.adrianczerwinski.topnbaplayers.data.remote.NBAApi
import com.adrianczerwinski.topnbaplayers.domain.model.Hero
import com.adrianczerwinski.topnbaplayers.domain.repository.RemoteDataSource
import com.adrianczerwinski.topnbaplayers.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val NBAApi: NBAApi,
    private val NBAHeroesDatabase: NBAHeroesDatabase
): RemoteDataSource {

    private val heroDao = NBAHeroesDatabase.heroDao()

    @ExperimentalPagingApi
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {heroDao.getAllHeroes()}
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                NBAApi = NBAApi,
                NBAHeroesDatabase = NBAHeroesDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(NBAApi = NBAApi, query = query)
            }
        ).flow
    }
}