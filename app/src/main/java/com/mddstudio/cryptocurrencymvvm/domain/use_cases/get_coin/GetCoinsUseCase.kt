package com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin

import com.mddstudio.cryptocurrencymvvm.common.Resource
import com.mddstudio.cryptocurrencymvvm.data.remote.dto.toCoin
import com.mddstudio.cryptocurrencymvvm.domain.model.Coin
import com.mddstudio.cryptocurrencymvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke():kotlinx.coroutines.flow.Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
         val coins=repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e:Exception){
            emit(Resource.Error<List<Coin>>("Error" + e))

        }
    }
}