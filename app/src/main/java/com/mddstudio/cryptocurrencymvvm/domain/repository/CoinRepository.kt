package com.mddstudio.cryptocurrencymvvm.domain.repository

import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDetailDto
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}