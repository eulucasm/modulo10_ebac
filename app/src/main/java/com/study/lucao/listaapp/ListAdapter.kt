package com.study.lucao.listaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.lucao.listaapp.databinding.ItemBinding

class ListAdapter(
    val listener: ListAdapterListener,
    val listItemMock: MutableList<ListItem>
) : RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {

        return ListItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item =  listItemMock[position]

        holder.posicao.text = position.toString()
        holder.conteudo.text = item.city

        holder.viewRoot.setOnClickListener {
            listener.onItemClicked(item.city)
        }
    }

    override fun getItemCount(): Int {
        return listItemMock.size
    }

    class ListItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var viewRoot = binding.root
        val posicao = binding.posicao
        val conteudo = binding.conteudo
    }

    interface ListAdapterListener{
        fun onItemClicked(content: String)
    }
}