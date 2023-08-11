package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewexample.adapter.FoodGridLayoutAdapter
import com.example.recyclerviewexample.databinding.ActivityGridLayoutBinding
import com.example.recyclerviewexample.model.Food

class GridLayoutActivity : AppCompatActivity() {
    private val binding: ActivityGridLayoutBinding by lazy {
        ActivityGridLayoutBinding.inflate(layoutInflater)
    }

    private val foodAdapter by lazy {
        FoodGridLayoutAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.rcvFood.layoutManager = gridLayoutManager
        foodAdapter.setData(getListFood())
        binding.rcvFood.adapter = foodAdapter
    }

    private fun getListFood(): MutableList<Food> {
        return mutableListOf(
            Food(R.drawable.slide_item_1, "Food 1"),
            Food(R.drawable.slide_item_2, "Food 2"),
            Food(R.drawable.slide_item_3, "Food 3"),

            Food(R.drawable.slide_item_1, "Food 4"),
            Food(R.drawable.slide_item_2, "Food 5"),
            Food(R.drawable.slide_item_3, "Food 6"),

            Food(R.drawable.slide_item_1, "Food 7"),
            Food(R.drawable.slide_item_2, "Food 8"),
            Food(R.drawable.slide_item_3, "Food 9"),

            Food(R.drawable.slide_item_1, "Food 10"),
            Food(R.drawable.slide_item_2, "Food 11"),
            Food(R.drawable.slide_item_3, "Food 12"),
        )
    }
}