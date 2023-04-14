package com.example.recycler_view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycler_view.Naruto
import com.example.recycler_view.databinding.ItemNinjaBinding

class NinjaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemNinjaBinding.bind(view)

    fun render(ninjaModel: Naruto, onClickListener: (Naruto) -> Unit, onClickDelet: (Int) -> Unit) {
        binding.ninjaName.text = ninjaModel.ninja
        binding.villageName.text = ninjaModel.village
        Glide.with(binding.ivNinja.context).load(ninjaModel.image).into(binding.ivNinja)
        itemView.setOnClickListener { onClickListener(ninjaModel) }
        binding.deletButton.setOnClickListener{onClickDelet(adapterPosition)}
    }
}