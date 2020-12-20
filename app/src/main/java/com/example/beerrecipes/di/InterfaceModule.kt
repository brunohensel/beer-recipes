package com.example.beerrecipes.di

import com.example.beerrecipes.data.source.BeerDataSource
import com.example.beerrecipes.data.source.BeerRepository
import com.example.beerrecipes.data.source.BeerRepositoryImpl
import com.example.beerrecipes.data.source.remote.BeerRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun bindBeerDataSource(beerRemoteDataSource: BeerRemoteDataSource): BeerDataSource

    @Binds
    abstract fun bindBeerRepository(beerRepository: BeerRepositoryImpl): BeerRepository
}