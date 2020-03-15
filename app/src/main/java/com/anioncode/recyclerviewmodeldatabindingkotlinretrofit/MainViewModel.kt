package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){

    val mutableList = MutableLiveData<List<Model>>()

    fun setList(lista:List<Model>){
        mutableList.value=lista
    }
    fun getList(): LiveData<List<Model>> {
        return mutableList
    }

}