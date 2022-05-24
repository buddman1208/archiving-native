package com.samderra.archive.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.samderra.archive.R

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.mango)
        .error(R.drawable.mango)
        .into(this)
}