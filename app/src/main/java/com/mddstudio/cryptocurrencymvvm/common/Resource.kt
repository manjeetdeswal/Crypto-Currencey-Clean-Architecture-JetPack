package com.mddstudio.cryptocurrencymvvm.common

sealed class Resource<T>(val data:T? =null,val error:String? =null) {

    class Success <T>(data: T?): Resource<T>(data = data)
    class Error<T>(mesaage:String,data: T?=null): Resource<T>(data = data,mesaage)
    class Loading<T>(data: T?=null): Resource<T>(data = data)
}