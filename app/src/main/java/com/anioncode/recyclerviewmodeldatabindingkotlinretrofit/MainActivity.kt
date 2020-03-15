package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    var lista = mutableListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InitData()
        ViewModelInit()
        LoadData()

    }

    fun InitData(){

        itemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(lista)
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

    fun LoadData() {

        lista.add(Model("Apple Pie"))
        lista.add(Model("Banana Bread"))
        lista.add(Model("Cupcake"))
        lista.add(Model("Donut"))
        lista.add(Model("Eclair"))
        lista.add(Model("Froyo"))
        lista.add(Model("Gingerbread"))
        lista.add(Model("Honeycomb"))
        lista.add(Model("Ice Cream Sandwich"))
        lista.add(Model("Jelly Bean"))
        lista.add(Model("KitKat"))
        lista.add(Model("Lollipop"))
        lista.add(Model("Marshmallow"))
        lista.add(Model("Nougat"))
        lista.add(Model("Oreo"))
        lista.add(Model("Pie"))
        lista.add(Model("Android 10"))
        lista.add(Model("Android 11 Developer Preview"))

        mainViewModel.setList(lista)
    }
}
