package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.Result
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.databinding.ItemTekstBinding

class ListAdapter(private val list: ImageModel) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTekstBinding.inflate(inflater)
        return ListViewHolder(binding)

    }

    override fun getItemCount(): Int = list.results.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {


        holder.bind(list.results[position])
    }


    inner class ListViewHolder(val binding: ItemTekstBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Result) {
///Ważne by odnosić się do naszego modelu
            binding.mydata = movie
            binding.executePendingBindings()

        }
    }
}