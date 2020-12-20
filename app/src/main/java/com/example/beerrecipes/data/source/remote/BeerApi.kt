package com.example.beerrecipes.data.source.remote

import com.example.beerrecipes.domain.BeerDto
import io.reactivex.Single
import retrofit2.http.GET

interface BeerApi {

    @GET("beers")
    fun fetchBeers(): Single<List<BeerDto>>
}