package com.mddstudio.cryptocurrencymvvm.domain.model

import com.mddstudio.cryptocurrencymvvm.data.remote.dto.*

data class CoinDetail (
    val description: String,
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,


        )