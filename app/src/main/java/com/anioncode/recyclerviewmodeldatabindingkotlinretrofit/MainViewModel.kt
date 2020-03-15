package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import com.squareup.picasso.Picasso

class MainViewModel :ViewModel(){

    val mutableList = MutableLiveData<ImageModel>()

    fun setList(lista:ImageModel){
        mutableList.value=lista

    }
    fun getList(): LiveData<ImageModel> {
        return mutableList
    }

}