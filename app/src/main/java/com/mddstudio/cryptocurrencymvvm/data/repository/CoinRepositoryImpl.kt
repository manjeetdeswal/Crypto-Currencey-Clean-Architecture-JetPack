package com.mddstudio.cryptocurrencymvvm.data.repository

import androidx.compose.foundation.lazy.rememberLazyListState
import com.mddstudio.cryptocurrencymvvm.data.remote.CoinApi
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDetailDto
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.CoinDto
import com.mddstudio.cryptocurrencymvvm.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinApi):CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}