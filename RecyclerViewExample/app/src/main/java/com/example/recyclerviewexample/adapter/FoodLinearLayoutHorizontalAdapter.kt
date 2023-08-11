package com.example.recyclerviewexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemLinearLayoutHorizontalFoodBinding
import com.example.recyclerviewexample.model.Food

class FoodLinearLayoutHorizontalAdapter(
    private val context: Context
) : RecyclerView.Adapter<FoodLinearLayoutHorizontalAdapter.FoodViewHolder>() {

    private var listFoods: MutableList<Food> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val binding = ItemLinearLayoutHorizontalFoodBinding.inflate(LayoutInflater.from(context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFoods.size
    }

    fun setData(listFoods: MutableList<Food>) {
        this.listFoods = listFoods
    }

    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int
    ) {
        holder.bindData(listFoods[position])
    }

    inner class FoodViewHolder(private val binding: ItemLinearLayoutHorizontalFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(food: Food) {
            binding.imgFood.setImageResource(food.resourceImage)
            binding.tvName.text = food.name
        }
    }
}