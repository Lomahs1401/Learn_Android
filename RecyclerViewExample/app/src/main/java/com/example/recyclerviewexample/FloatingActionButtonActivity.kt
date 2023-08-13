package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView.OnScrollListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.FoodGridLayoutAdapter
import com.example.recyclerviewexample.databinding.ActivityFloatingActionButtonBinding
import com.example.recyclerviewexample.model.Food

class FloatingActionButtonActivity : AppCompatActivity() {
    private val binding: ActivityFloatingActionButtonBinding by lazy {
        ActivityFloatingActionButtonBinding.inflate(layoutInflater)
    }

    private val foodGridLayoutAdapter: FoodGridLayoutAdapter by lazy {
        FoodGridLayoutAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.rcvFood.layoutManager = gridLayoutManager

        foodGridLayoutAdapter.setData(getListFood())

        binding.rcvFood.adapter = foodGridLayoutAdapter
        binding.rcvFood.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    binding.btnFloating.hide()
                } else {
                    binding.btnFloating.show()
                }
            }
        })
    }

    private fun getListFood(): MutableList<Food> {
        return mutableListOf(
            Food(R.drawable.slide_item_1, "Food 1"),
            Food(R.drawable.slide_item_2, "Food 2"),
            Food(R.drawable.slide_item_3, "Food 3"),
            Food(R.drawable.slide_item_4, "Food 4"),

            Food(R.drawable.slide_item_2, "Food 5"),
            Food(R.drawable.slide_item_3, "Food 6"),
            Food(R.drawable.slide_item_1, "Food 7"),
            Food(R.drawable.slide_item_4, "Food 8"),

            Food(R.drawable.slide_item_4, "Food 9"),
            Food(R.drawable.slide_item_1, "Food 10"),
            Food(R.drawable.slide_item_3, "Food 11"),
            Food(R.drawable.slide_item_2, "Food 12"),
        )
    }
}