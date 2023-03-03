package com.study.lucao.listaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.study.lucao.listaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListAdapter.ListAdapterListener {

    private lateinit var binding: ActivityMainBinding

    private val itemList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.recycleView

        createMockData()

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = ListAdapter(this,itemList)
    }

    private fun createMockData() {
        itemList.add(ListItem("Lucas", "São PauloSão PauloSão PauloSão PauloSão PauloSão Paulo"))
        itemList.add(ListItem("LucasLucas", "São PauloSão PauloSão PauloSão PauloSão Paulo"))
        itemList.add(ListItem("LucasLucasLucas", "São PauloSão PauloSão PauloSão Paulo"))
        itemList.add(ListItem("LucasLucasLucasLucas", "São PauloSão PauloSão Paulo"))
        itemList.add(ListItem("LucasLucasLucasLucasLucas", "São PauloSão Paulo"))
        itemList.add(ListItem("LucasLucasLucasLucasLucasLucas", "São Paulo"))
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }
}