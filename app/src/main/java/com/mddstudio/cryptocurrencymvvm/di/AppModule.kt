package com.mddstudio.cryptocurrencymvvm.di

import com.mddstudio.cryptocurrencymvvm.common.Constant
import com.mddstudio.cryptocurrencymvvm.data.remote.CoinApi
import com.mddstudio.cryptocurrencymvvm.data.repository.CoinRepositoryImpl
import com.mddstudio.cryptocurrencymvvm.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi():CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepo(api: CoinApi):CoinRepository{
        return CoinRepositoryImpl(api =api)
    }
}