package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemCircleImageFoodBinding
import com.example.recyclerviewexample.databinding.ItemGridLayoutFoodBinding
import com.example.recyclerviewexample.model.FoodMultiple

class FoodMultipleViewHolderAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listFoodsMultiple: MutableList<FoodMultiple> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_FOOD_FEATURED) {
            FoodFeaturedViewHolder(
                ItemGridLayoutFoodBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
            )
        } else {
            FoodNormalViewHolder(
                ItemCircleImageFoodBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return listFoodsMultiple.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val foodMultiple = listFoodsMultiple[position]
        if (holder.itemViewType == TYPE_FOOD_FEATURED) {
            val foodFeaturedViewHolder = holder as FoodFeaturedViewHolder
            foodFeaturedViewHolder.bindData(foodMultiple)
        } else if (holder.itemViewType == TYPE_FOOD_NORMAL) {
            val foodNormalViewHolder = holder as FoodNormalViewHolder
            foodNormalViewHolder.bindData(foodMultiple)
        }
    }


    override fun getItemViewType(position: Int): Int {
        val food = listFoodsMultiple[position]
        return if (food.isFeatured) {
            TYPE_FOOD_FEATURED
        } else {
            TYPE_FOOD_NORMAL
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listFoodsMultiple: MutableList<FoodMultiple>) {
        this.listFoodsMultiple = listFoodsMultiple
        notifyDataSetChanged()
    }

    inner class FoodFeaturedViewHolder(private val binding: ItemGridLayoutFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(food: FoodMultiple) {
            binding.imgFood.setImageResource(food.resourceImage)
            binding.tvName.text = food.name
        }
    }

    inner class FoodNormalViewHolder(private val binding: ItemCircleImageFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(food: FoodMultiple) {
            binding.imgFood.setImageResource(food.resourceImage)
            binding.tvName.text = food.name
        }
    }

    companion object {
        const val TYPE_FOOD_FEATURED = 1
        const val TYPE_FOOD_NORMAL = 2
    }
}