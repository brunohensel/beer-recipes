package com.example.beerrecipes

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.beerrecipes.domain.BeerState
import com.example.beerrecipes.domain.NetworkException.*
import com.example.beerrecipes.presantation.BeerViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: BeerViewModel by viewModels()
    private val disposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel
            .getBeerState()
            .subscribe(
                { state: BeerState -> renderState(state) },
                { error: Throwable -> displayError(error) })
            .also { disposable.add(it) }
    }

    private fun displayError(error: Throwable) {
        when (error) {
            is NoNetworkException -> Log.e("Network Exception", "${error.error}")
            is ServerUnreachableException -> Log.e("Server Unreachable", "${error.error}")
            is HttpCallFailureException -> Log.e("Http Failed", "${error.error}")
            else -> Log.e("Unknown Exception", "$error")
        }
    }

    private fun renderState(state: BeerState) {
        when (state) {
            is BeerState.Success -> Log.d("List of Beers:", "${state.beers}")
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}