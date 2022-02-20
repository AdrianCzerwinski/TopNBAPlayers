package com.adrianczerwinski.topnbaplayers.di

import android.content.Context
import androidx.room.Room
import com.adrianczerwinski.topnbaplayers.data.local.BorutoDatabase
import com.adrianczerwinski.topnbaplayers.data.repository.LocalDataSourceImpl
import com.adrianczerwinski.topnbaplayers.domain.repository.LocalDataSource
import com.adrianczerwinski.topnbaplayers.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BorutoDatabase::class.java,
        BORUTO_DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(db: BorutoDatabase): LocalDataSource{
        return LocalDataSourceImpl(
            borutoDatabase = db
        )
    }
}