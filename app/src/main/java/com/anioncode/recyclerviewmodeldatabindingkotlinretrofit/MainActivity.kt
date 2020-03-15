package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.Connection.ApiService
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.Connection.RetrofitClientInstance
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var imageModel :ImageModel
    var lista = mutableListOf<ImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)
        val params: MutableMap<String, String> =
            HashMap()
        params["client_id"] = "_M00yQiE78fDwvaXtnv-a53JKNAqUalD6YbuDHmztLA"
        params["page"] = "1"
        params["query"] = "Bea"

        api.fetchAllUsers(params).enqueue(object : Callback<ImageModel> {


            override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {

                imageModel = response.body()!!
                println(imageModel!!.results[0].urls.regular)
           //     println(response.body())

                InitData()
                ViewModelInit()
                LoadData(imageModel)
            }

            override fun onFailure(call: Call<ImageModel>, t: Throwable) {

                println("It is no ok")

            }


        })






    }

    fun InitData(){

        itemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(imageModel,this@MainActivity)
        }

    }

    fun ViewModelInit() {

        mainViewModel = this!!.run {
            ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        }

        mainViewModel.getList().observe(this, Observer {
            itemList.adapter!!.notifyDataSetChanged()
        })
    }

    fun LoadData(imageModel : ImageModel) {

        mainViewModel.setList(imageModel)
    }
}
