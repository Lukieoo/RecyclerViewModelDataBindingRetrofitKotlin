package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.Connection

import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search/photos?client_id=_M00yQiE78fDwvaXtnv-a53JKNAqUalD6YbuDHmztLA&page=1&query=Game")
    fun  fetchAllUsers(): Call<ImageModel>
}