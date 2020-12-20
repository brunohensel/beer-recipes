package com.example.beerrecipes.presantation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.beerrecipes.data.interactors.fetchBeers.FetchBeers
import com.example.beerrecipes.domain.BeerState
import com.example.beerrecipes.utils.mapNetworkErrors
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BeerViewModel @ViewModelInject constructor(private val fetchBeers: FetchBeers) : ViewModel() {

    fun getBeerState(): Single<BeerState> =
        fetchBeers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .mapNetworkErrors()
            .map { BeerState.Success(it) }
}