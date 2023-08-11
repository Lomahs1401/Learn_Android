package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.CategoryAdapter
import com.example.recyclerviewexample.adapter.FoodLinearLayoutHorizontalAdapter
import com.example.recyclerviewexample.databinding.ActivityLinearLayoutHorizontalBinding
import com.example.recyclerviewexample.model.Category
import com.example.recyclerviewexample.model.Food

class LinearLayoutHorizontalActivity : AppCompatActivity() {
    private val binding: ActivityLinearLayoutHorizontalBinding by lazy {
        ActivityLinearLayoutHorizontalBinding.inflate(layoutInflater)
    }

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rcvCategory.layoutManager = linearLayoutManager
        categoryAdapter.setData(getListCategory())
        binding.rcvCategory.adapter = categoryAdapter
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
            Category(
                nameCategory = "Category 4",
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
                nameCategory = "Category 5",
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
                nameCategory = "Category 6",
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
}