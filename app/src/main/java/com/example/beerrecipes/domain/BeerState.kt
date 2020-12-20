package com.example.beerrecipes.domain

sealed class BeerState {
    data class Success(val beers: List<BeerDto>) : BeerState()
}