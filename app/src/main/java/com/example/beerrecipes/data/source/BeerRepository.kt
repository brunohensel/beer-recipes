package com.example.beerrecipes.data.source

import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single

interface BeerRepository {
    fun fetchBeerRecipes(): Single<List<BeerDto>>
}