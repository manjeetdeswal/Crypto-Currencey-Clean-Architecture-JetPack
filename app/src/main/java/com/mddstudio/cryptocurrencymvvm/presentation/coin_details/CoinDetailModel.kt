package com.mddstudio.cryptocurrencymvvm.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mddstudio.cryptocurrencymvvm.common.Constant
import com.mddstudio.cryptocurrencymvvm.common.Resource
import com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin.GetCoinUseCase
import com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin.GetCoinsUseCase
import com.mddstudio.cryptocurrencymvvm.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle:SavedStateHandle
):ViewModel(){


private val _state = mutableStateOf(CoinDetailState())
    val state :State<CoinDetailState> =_state

    init {
        savedStateHandle.get<String>(Constant.PARAM_ID)?.let { coinId ->
            getCoins(coinId)
        }
    }
    private fun getCoins(coinID:String?){
        getCoinUseCase(coinID!!).onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinDetailState(coins = result.data)
                }
                is Resource.Error->{
                    _state.value =CoinDetailState(false, error = result.error.toString())
                }
                is Resource.Loading->{
                    _state.value = CoinDetailState(true)

                }

            }
        }.launchIn(viewModelScope)
    }
}