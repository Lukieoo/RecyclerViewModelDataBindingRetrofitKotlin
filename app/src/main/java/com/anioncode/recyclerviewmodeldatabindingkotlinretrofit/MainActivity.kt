package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    lateinit var adapter2 :ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StartBase()

        ViewModelInit()

        ImageClick()



    }

    private fun ImageClick() {
        find.setOnClickListener(View.OnClickListener {

            val apix = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)
            val paramsx: MutableMap<String, String> =
                HashMap()
            paramsx["client_id"] = "_M00yQiE78fDwvaXtnv-a53JKNAqUalD6YbuDHmztLA"
            paramsx["page"] = "1"
            paramsx["query"] = editext.text.toString()

            apix.fetchAllUsers(paramsx).enqueue(object : Callback<ImageModel> {


                override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {

                    imageModel = response.body()!!

                    // InitData(imageModel)

                    LoadData(imageModel)
                    itemList.adapter!!.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<ImageModel>, t: Throwable) {

                    println("It is no ok")
                    print("error")
                }


            })
            Toast.makeText(this, editext.text.toString(), Toast.LENGTH_LONG).show()
        })
    }

    private fun StartBase() {
        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)
        val params: MutableMap<String, String> =
            HashMap()
        params["client_id"] = "_M00yQiE78fDwvaXtnv-a53JKNAqUalD6YbuDHmztLA"
        params["page"] = "1"
        params["query"] = "Bea"

        api.fetchAllUsers(params).enqueue(object : Callback<ImageModel> {


            override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {

                imageModel = response.body()!!

                InitData(imageModel)
                LoadData(imageModel)
            }

            override fun onFailure(call: Call<ImageModel>, t: Throwable) {

                println("It is no ok")

            }


        })
    }

    fun InitData(imageModel : ImageModel){

        itemList.apply {
              adapter2= ListAdapter(imageModel,this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =adapter2;
        }

    }

    fun ViewModelInit() {

        mainViewModel = this!!.run {
            ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        }

        mainViewModel.getList().observe(this, Observer {
            adapter2.setData(imageModel)
            itemList.adapter!!.notifyDataSetChanged()

        })
    }

    fun LoadData(imageModel : ImageModel) {

        mainViewModel.setList(imageModel)

    }

}
