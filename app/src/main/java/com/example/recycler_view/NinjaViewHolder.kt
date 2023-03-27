package com.example.recycler_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NinjaViewHolder(view:View) : RecyclerView.ViewHolder(view){

    val image = view.findViewById<ImageView>(R.id.ivNinja)
    val ninja = view.findViewById<TextView>(R.id.ninjaName)
    val village = view.findViewById<TextView>(R.id.villageName)

    fun render(ninjaModel : Naruto){
        ninja.text = ninjaModel.ninja
        village.text = ninjaModel.village
        Glide.with(image.context).load(ninjaModel.image).into(image)
    }
}