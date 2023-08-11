package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.FoodLinearLayoutVerticalAdapter
import com.example.recyclerviewexample.databinding.ActivityLinearLayoutVerticalBinding
import com.example.recyclerviewexample.model.Food

class LinearLayoutVerticalActivity : AppCompatActivity() {
    private val binding: ActivityLinearLayoutVerticalBinding by lazy {
        ActivityLinearLayoutVerticalBinding.inflate(layoutInflater)
    }

    private val foodAdapter: FoodLinearLayoutVerticalAdapter by lazy {
        FoodLinearLayoutVerticalAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.rcvFood.layoutManager = linearLayoutManager
        binding.rcvFood.adapter = foodAdapter
        foodAdapter.setData(getListFood())
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