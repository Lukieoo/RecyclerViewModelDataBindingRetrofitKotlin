package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.R.attr.label
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.databinding.ItemTekstBinding
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.ImageModel
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi.Result


class ListAdapter(private var list: ImageModel, var context: Activity) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTekstBinding.inflate(inflater)
        return ListViewHolder(binding)

    }

     fun setData(  list: ImageModel){
        this.list=list
    }

    override fun getItemCount(): Int = list.results.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val clipboard =
                context.applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", list.results[position].urls.regular)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context,"Copied to clipboard",Toast.LENGTH_LONG).show()
        }

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