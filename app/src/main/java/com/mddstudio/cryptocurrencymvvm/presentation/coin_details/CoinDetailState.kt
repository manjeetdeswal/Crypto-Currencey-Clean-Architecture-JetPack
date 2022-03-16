package com.mddstudio.cryptocurrencymvvm.presentation.coin_details

import com.mddstudio.cryptocurrencymvvm.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coins:CoinDetail? = null,
    val error:String=""
)