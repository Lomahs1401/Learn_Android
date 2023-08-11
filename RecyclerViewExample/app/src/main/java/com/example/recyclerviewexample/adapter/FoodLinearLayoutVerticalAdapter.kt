package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemLinearLayoutVerticalFoodBinding
import com.example.recyclerviewexample.model.Food

class FoodLinearLayoutVerticalAdapter(
    private val context: Context
) : RecyclerView.Adapter<FoodLinearLayoutVerticalAdapter.FoodViewHolder>() {

    private var listFoods: MutableList<Food> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemLinearLayoutVerticalFoodBinding.inflate(LayoutInflater.from(context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFoods.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindData(listFoods[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listFoods: MutableList<Food>) {
        this.listFoods = listFoods
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: ItemLinearLayoutVerticalFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(food: Food) {
            binding.imgFood.setImageResource(food.resourceImage)
            binding.tvName.text = food.name
        }
    }
}