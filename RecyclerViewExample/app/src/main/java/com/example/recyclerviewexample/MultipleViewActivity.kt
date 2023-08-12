package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.adapter.FoodLinearLayoutVerticalAdapter
import com.example.recyclerviewexample.adapter.FoodMultipleViewHolderAdapter
import com.example.recyclerviewexample.databinding.ActivityMultipleViewBinding
import com.example.recyclerviewexample.model.Food
import com.example.recyclerviewexample.model.FoodMultiple

class MultipleViewActivity : AppCompatActivity() {
    private val binding: ActivityMultipleViewBinding by lazy {
        ActivityMultipleViewBinding.inflate(layoutInflater)
    }

    private val foodMultipleAdapter: FoodMultipleViewHolderAdapter by lazy {
        FoodMultipleViewHolderAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvMultipleView.layoutManager = linearLayoutManager
        foodMultipleAdapter.setData(getListFoodMultiple())
        binding.rcvMultipleView.adapter = foodMultipleAdapter

    }

    private fun getListFoodMultiple(): MutableList<FoodMultiple> {
        return mutableListOf(
            FoodMultiple(R.drawable.slide_item_1, "FoodMultiple 1", true),
            FoodMultiple(R.drawable.slide_item_2, "FoodMultiple 2", true),
            FoodMultiple(R.drawable.slide_item_3, "FoodMultiple 3", true),

            FoodMultiple(R.drawable.slide_item_1, "FoodMultiple 4", false),
            FoodMultiple(R.drawable.slide_item_2, "FoodMultiple 5", false),
            FoodMultiple(R.drawable.slide_item_3, "FoodMultiple 6", false),

            FoodMultiple(R.drawable.slide_item_1, "FoodMultiple 7", true),
            FoodMultiple(R.drawable.slide_item_2, "FoodMultiple 8", true),
            FoodMultiple(R.drawable.slide_item_3, "FoodMultiple 9", true),

            FoodMultiple(R.drawable.slide_item_1, "FoodMultiple 10", false),
            FoodMultiple(R.drawable.slide_item_2, "FoodMultiple 11", false),
            FoodMultiple(R.drawable.slide_item_3, "FoodMultiple 12", false),
        )
    }
}