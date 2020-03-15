package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.Connection

import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("search/photos")
    fun  fetchAllUsers(@QueryMap params:Map<String, String>): Call<ImageModel>
}

//client_id
//page
//query
//@GET("search/photos?client_id=_M00yQiE78fDwvaXtnv-a53JKNAqUalD6YbuDHmztLA&page=1&query=sexy")