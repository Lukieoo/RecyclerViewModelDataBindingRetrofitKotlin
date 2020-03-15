package com.anioncode.recyclerviewmodeldatabindingkotlinretrofit.modelApi

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.squareup.picasso.Picasso

data class Result(
    val alt_description: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: String,
    val id: String,
    val liked_by_user: Boolean,
    val likes: String,
    val links: Links,
    val promoted_at: String,
    val tags: List<Tag>,
    val updated_at: String,
    val urls: UrlsX,
    val user: UserX,
    val width: String


) {
    companion object {
        @JvmStatic @BindingAdapter("MyExample")
        fun setImageUrl(imageView: ImageView, url: String?) {
            Picasso.get().load(url).into(imageView);
        }
    }
}

