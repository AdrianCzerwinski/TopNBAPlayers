package com.adrianczerwinski.borutoapp.di

import android.content.Context
import com.adrianczerwinski.borutoapp.data.repository.DataStoreOperationsImpl
import com.adrianczerwinski.borutoapp.data.repository.Repository
import com.adrianczerwinski.borutoapp.domain.repository.DataStoreOperations
import com.adrianczerwinski.borutoapp.domain.use_cases.UseCases
import com.adrianczerwinski.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.adrianczerwinski.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardinfUseCase
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
            saveOnBoardinfUseCase = SaveOnBoardinfUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository)
        )
    }

}