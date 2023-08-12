package com.example.recyclerviewexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.adapter.CategoryAdapter
import com.example.recyclerviewexample.adapter.FoodGridLayoutAdapter
import com.example.recyclerviewexample.adapter.FoodLinearLayoutVerticalAdapter
import com.example.recyclerviewexample.databinding.ActivityNestedScrollViewBinding
import com.example.recyclerviewexample.model.Category
import com.example.recyclerviewexample.model.Food

class NestedScrollViewActivity : AppCompatActivity() {
    private val binding: ActivityNestedScrollViewBinding by lazy {
        ActivityNestedScrollViewBinding.inflate(layoutInflater)
    }

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(context = applicationContext)
    }

    private val foodGridLayoutAdapter: FoodGridLayoutAdapter by lazy {
        FoodGridLayoutAdapter(context = applicationContext)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.rcvCategory.layoutManager = gridLayoutManager
        binding.rcvCategory.isFocusable = false
        binding.rcvCategory.isNestedScrollingEnabled = false
        categoryAdapter.setData(getListCategory())
        binding.rcvCategory.adapter = categoryAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvFood.layoutManager = linearLayoutManager
        binding.rcvFood.isFocusable = false
        binding.rcvFood.isNestedScrollingEnabled = false
        foodGridLayoutAdapter.setData(getListFood())
        binding.rcvFood.adapter = foodGridLayoutAdapter
    }

    private fun getListCategory(): MutableList<Category> {
        return mutableListOf(
            Category(
                nameCategory = "Category 1",
                listFoods = mutableListOf(
                    Food(
                        name = "Food 1",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 2",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 3",
                        resourceImage = R.drawable.slide_item_3
                    ),
                    Food(
                        name = "Food 4",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 5",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 6",
                        resourceImage = R.drawable.slide_item_3
                    ),
                )
            ),
            Category(
                nameCategory = "Category 2",
                listFoods = mutableListOf(
                    Food(
                        name = "Food 1",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 2",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 3",
                        resourceImage = R.drawable.slide_item_3
                    ),
                    Food(
                        name = "Food 4",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 5",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 6",
                        resourceImage = R.drawable.slide_item_3
                    ),
                )
            ),
            Category(
                nameCategory = "Category 3",
                listFoods = mutableListOf(
                    Food(
                        name = "Food 1",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 2",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 3",
                        resourceImage = R.drawable.slide_item_3
                    ),
                    Food(
                        name = "Food 4",
                        resourceImage = R.drawable.slide_item_1
                    ),
                    Food(
                        name = "Food 5",
                        resourceImage = R.drawable.slide_item_2
                    ),
                    Food(
                        name = "Food 6",
                        resourceImage = R.drawable.slide_item_3
                    ),
                )
            ),
        )
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