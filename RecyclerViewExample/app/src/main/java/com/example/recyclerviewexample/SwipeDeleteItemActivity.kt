package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.FoodCircleImageAdapter
import com.example.recyclerviewexample.databinding.ActivitySwipeDeleteItemBinding
import com.example.recyclerviewexample.model.Food

class  SwipeDeleteItemActivity : AppCompatActivity() {
    private val binding: ActivitySwipeDeleteItemBinding by lazy {
        ActivitySwipeDeleteItemBinding.inflate(layoutInflater)
    }

    private val foodCircleImageAdapter: FoodCircleImageAdapter by lazy {
        FoodCircleImageAdapter()
    }

    private var listFoods: MutableList<Food> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvFood.layoutManager = linearLayoutManager

        listFoods = getListFoods()
        foodCircleImageAdapter.setData(listFoods)

        binding.rcvFood.adapter = foodCircleImageAdapter

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rcvFood.addItemDecoration(itemDecoration)

        val itemTouchHelper = ItemTouchHelper(object : SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                listFoods.removeAt(position)
                foodCircleImageAdapter.setData(listFoods)
            }
        }).apply {
            attachToRecyclerView(binding.rcvFood)
        }
    }

    private fun getListFoods(): MutableList<Food> {
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