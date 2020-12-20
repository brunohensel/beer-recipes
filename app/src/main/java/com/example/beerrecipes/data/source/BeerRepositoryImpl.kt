package com.example.beerrecipes.data.source

import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(private val beerDataSource: BeerDataSource)
    : BeerRepository {

    override fun fetchBeerRecipes(): Single<List<BeerDto>> {
        return beerDataSource.fetchBeerRecipes()
    }
}