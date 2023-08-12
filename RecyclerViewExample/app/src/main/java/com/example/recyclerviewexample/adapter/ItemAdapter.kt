package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.LayoutItemBinding

class ItemAdapter(
    private val context: Context
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var listItems: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(listItems[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: MutableList<String>) {
        this.listItems = items
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.tvItem.text = item
        }
    }
}