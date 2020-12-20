package com.example.beerrecipes.data.interactors.fetchBeers

import com.example.beerrecipes.data.source.BeerRepository
import javax.inject.Inject

class FetchBeers @Inject constructor(private val beerRepository: BeerRepository) {

    operator fun invoke() = beerRepository.fetchBeerRecipes()
}