package com.example.beerrecipes.data.source

import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single

interface BeerDataSource {
    fun fetchBeerRecipes(): Single<List<BeerDto>>
}