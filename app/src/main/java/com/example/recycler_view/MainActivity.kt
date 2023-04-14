package com.example.recycler_view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.adapter.NinjaAdapter
import com.example.recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerNaruto.layoutManager = manager
        binding.recyclerNaruto.adapter =
            NinjaAdapter(NinjaProvider.ninjaList) { ninja -> onItemSelected(ninja) }
        binding.recyclerNaruto.addItemDecoration(decoration)
    }

    fun onItemSelected(ninja: Naruto) {
        Toast.makeText(this, ninja.ninja, Toast.LENGTH_SHORT).show()
    }
}