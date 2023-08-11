package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewexample.adapter.FoodGridLayoutAdapter
import com.example.recyclerviewexample.adapter.FoodStaggeredGridLayoutAdapter
import com.example.recyclerviewexample.databinding.ActivityStaggeredGridLayoutBinding
import com.example.recyclerviewexample.model.Food

class StaggeredGridLayoutActivity : AppCompatActivity() {
    private val binding: ActivityStaggeredGridLayoutBinding by lazy {
        ActivityStaggeredGridLayoutBinding.inflate(layoutInflater)
    }

    private val foodAdapter by lazy {
        FoodStaggeredGridLayoutAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rcvFood.layoutManager = staggeredGridLayoutManager
        foodAdapter.setData(getListFood())
        binding.rcvFood.adapter = foodAdapter
    }

    private fun getListFood(): MutableList<Food> {
        return mutableListOf(
            Food(R.drawable.slide_item_4, "Food 1"),
            Food(R.drawable.slide_item_2, "Food 2"),
            Food(R.drawable.slide_item_3, "Food 3"),
            Food(R.drawable.food_icon, "Food 4"),

            Food(R.drawable.slide_item_2, "Food 5"),
            Food(R.drawable.slide_item_3, "Food 6"),
            Food(R.drawable.slide_item_4, "Food 7"),
            Food(R.drawable.food_icon, "Food 8"),

            Food(R.drawable.slide_item_3, "Food 9"),
            Food(R.drawable.food_icon, "Food 10"),
            Food(R.drawable.slide_item_4, "Food 11"),
            Food(R.drawable.slide_item_2, "Food 12"),

            Food(R.drawable.food_icon, "Food 13"),
            Food(R.drawable.slide_item_2, "Food 14"),
            Food(R.drawable.slide_item_3, "Food 15"),
            Food(R.drawable.slide_item_4, "Food 16"),

        )
    }
}