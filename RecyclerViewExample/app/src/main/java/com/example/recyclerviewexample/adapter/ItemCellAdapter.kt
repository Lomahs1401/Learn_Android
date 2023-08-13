package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.LayoutItemFoddingBinding
import com.example.recyclerviewexample.model.ItemCell

class ItemCellAdapter(
    private val context: Context
) : RecyclerView.Adapter<ItemCellAdapter.ItemCellViewHolder>() {

    private var listItemCell: MutableList<ItemCell> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItemCell: MutableList<ItemCell>) {
        this.listItemCell = listItemCell
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCellViewHolder {
        val binding = LayoutItemFoddingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemCellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemCell.size
    }

    override fun onBindViewHolder(holder: ItemCellViewHolder, position: Int) {
        holder.bindData(listItemCell[position])
    }

    inner class ItemCellViewHolder(private val binding: LayoutItemFoddingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(itemCell: ItemCell) {
            binding.tvContent.text = itemCell.content
            binding.tvTitle.text = itemCell.title
            binding.foldingCell.setOnClickListener {
                binding.foldingCell.toggle(false)
            }

            binding.tvTitle.setOnClickListener {
                Toast.makeText(context, itemCell.title, Toast.LENGTH_SHORT).show()
            }

            binding.tvContent.setOnClickListener {
                Toast.makeText(context, itemCell.content, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
