package com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin

import com.mddstudio.cryptocurrencymvvm.common.Resource
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.toCoin
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.toCoinDetail
import com.mddstudio.cryptocurrencymvvm.domain.model.Coin
import com.mddstudio.cryptocurrencymvvm.domain.model.CoinDetail
import com.mddstudio.cryptocurrencymvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId:String):kotlinx.coroutines.flow.Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
         val coin=repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e:Exception){
            emit(Resource.Error<CoinDetail>("Error" + e))

        }
    }
}