package com.adrianczerwinski.borutoapp.di

import android.content.Context
import com.adrianczerwinski.borutoapp.data.repository.DataStoreOperationsImpl
import com.adrianczerwinski.borutoapp.data.repository.Repository
import com.adrianczerwinski.borutoapp.domain.repository.DataStoreOperations
import com.adrianczerwinski.borutoapp.domain.use_cases.UseCases
import com.adrianczerwinski.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardinfUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations{
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardinfUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository = repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository = repository)
        )
    }

}