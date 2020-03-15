package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.databinding.ItemTekstBinding

class ListAdapter(private val list: List<Model>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTekstBinding.inflate(inflater)
        return ListViewHolder(binding)

    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {


        holder.bind(list[position])
    }


    inner   class ListViewHolder(val binding: ItemTekstBinding) :RecyclerView.ViewHolder(binding.root) {
      //  private var mTitleView: TextView? = null

//        init {
//            mTitleView = itemView.findViewById(R.id.tekst)
//
//        }

        fun bind(movie: Model) {

                binding.mydata = movie
                binding.executePendingBindings()

        }
    }
}