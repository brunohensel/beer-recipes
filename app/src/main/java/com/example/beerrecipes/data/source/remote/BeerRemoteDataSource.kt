package com.example.beerrecipes.data.source.remote

import com.example.beerrecipes.data.BeerDataSource
import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single
import javax.inject.Inject

class BeerRemoteDataSource @Inject constructor(private val beerApi: BeerApi): BeerDataSource{

    override fun fetchBeerRecipes(): Single<List<BeerDto>> =
        beerApi
            .fetchBeers()
}