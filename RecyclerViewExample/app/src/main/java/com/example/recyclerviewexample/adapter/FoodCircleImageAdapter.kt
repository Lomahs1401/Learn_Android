package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemCircleImageFoodBinding
import com.example.recyclerviewexample.model.Food

class FoodCircleImageAdapter : RecyclerView.Adapter<FoodCircleImageAdapter.FoodViewHolder>() {
    private var listFoods: MutableList<Food> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listFoods: MutableList<Food>) {
        this.listFoods = listFoods
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemCircleImageFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFoods.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindData(food = listFoods[position])
    }

    inner class FoodViewHolder(private val binding: ItemCircleImageFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(food: Food) {
            binding.imgFood.setImageResource(food.resourceImage)
            binding.tvName.text = food.name
        }
    }
}