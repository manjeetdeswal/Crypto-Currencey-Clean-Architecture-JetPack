package com.mddstudio.cryptocurrencymvvm.data.remote

import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDetailDto
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String):CoinDetailDto
}