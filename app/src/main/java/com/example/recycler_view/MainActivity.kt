package com.example.recycler_view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.adapter.NinjaAdapter
import com.example.recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ninjaMutableList: MutableList<Naruto> = NinjaProvider.ninjaList.toMutableList()
    private lateinit var adapter: NinjaAdapter
    private val linearMana = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener { createNinja() }
        initRecyclerView()
    }

    fun initRecyclerView() {
        adapter = NinjaAdapter(
            ninjaList = ninjaMutableList,
            onClickListener = { ninja -> onItemSelected(ninja) },
            onClickDelet = { position -> onDeleteItem(position) }
        )
        val decoration = DividerItemDecoration(this, linearMana.orientation)
        binding.recyclerNaruto.layoutManager = linearMana
        binding.recyclerNaruto.addItemDecoration(decoration)
        binding.recyclerNaruto.adapter = adapter

    }

    private fun createNinja() {
        val ninja = Naruto(
            "Gaara",
            "Aldea de la arena",
            "https://i.pinimg.com/736x/3c/f7/99/3cf79913cd7b1ca4e6d936e3457f4772.jpg"
        )
        ninjaMutableList.add(ninja)
        adapter.notifyItemInserted(ninjaMutableList.size - 1)
        linearMana.scrollToPositionWithOffset(ninjaMutableList.size - 1, 10)
    }

    private fun onDeleteItem(positon: Int) {
        ninjaMutableList.removeAt(positon)
        adapter.notifyItemRemoved(positon)
    }

    private fun onItemSelected(ninja: Naruto) {
        Toast.makeText(this, ninja.ninja, Toast.LENGTH_SHORT).show()
    }
}