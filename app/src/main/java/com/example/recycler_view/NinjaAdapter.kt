package com.example.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NinjaAdapter (private val ninjaList : List<Naruto>): RecyclerView.Adapter<NinjaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NinjaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NinjaViewHolder(layoutInflater.inflate(R.layout.item_ninja, parent,false))
    }

    override fun getItemCount(): Int = ninjaList.size

    override fun onBindViewHolder(holder: NinjaViewHolder, position: Int) {
        val item = ninjaList[position]
        holder.render(item)
    }
}