package com.mddstudio.cryptocurrencymvvm.presentation

sealed class Screen(val route:String){
    object CoinDetailScreen:Screen("coin_detail")
    object CoinListScreen:Screen("coin_list")
}
