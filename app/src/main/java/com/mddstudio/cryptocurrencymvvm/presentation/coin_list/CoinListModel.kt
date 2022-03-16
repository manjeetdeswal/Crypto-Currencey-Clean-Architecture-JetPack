package com.mddstudio.cryptocurrencymvvm.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mddstudio.cryptocurrencymvvm.common.Resource
import com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin.GetCoinUseCase
import com.mddstudio.cryptocurrencymvvm.domain.use_cases.get_coin.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListModel @Inject constructor(
    private val getCoinUseCase: GetCoinsUseCase
):ViewModel(){

private val _state = mutableStateOf(CoinListState())
    val state :State<CoinListState> =_state

    init {
        getCoins()
    }
    private fun getCoins(){
        getCoinUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value =CoinListState(false, error = result.error.toString())
                }
                is Resource.Loading->{
                    _state.value = CoinListState(true)

                }

            }
        }.launchIn(viewModelScope)
    }
}