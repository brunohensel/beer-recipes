package com.example.beerrecipes.data

import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single

interface BeerDataSource {

    fun fetchBeerRecipes(): Single<List<BeerDto>>
}