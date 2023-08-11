package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemCategoryBinding
import com.example.recyclerviewexample.model.Category

class CategoryAdapter(
    private val context: Context
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var listCategories = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindData(listCategories[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listCategories: MutableList<Category>) {
        this.listCategories = listCategories
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(category: Category) {
            binding.tvCategory.text = category.nameCategory

            val linearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val foodLinearLayoutHorizontalAdapter = FoodLinearLayoutHorizontalAdapter(context)
            foodLinearLayoutHorizontalAdapter.setData(category.listFoods)

            binding.rcvCategory.layoutManager = linearLayoutManager
            binding.rcvCategory.adapter = foodLinearLayoutHorizontalAdapter
        }
    }
}