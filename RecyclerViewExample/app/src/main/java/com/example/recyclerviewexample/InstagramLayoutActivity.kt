package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.adapter.ListFoodPhotoAdapter
import com.example.recyclerviewexample.databinding.ActivityInstagramLayoutBinding
import com.example.recyclerviewexample.model.FoodPhoto
import com.example.recyclerviewexample.model.ListFoodPhoto

class InstagramLayoutActivity : AppCompatActivity() {
    private val binding: ActivityInstagramLayoutBinding by lazy {
        ActivityInstagramLayoutBinding.inflate(layoutInflater)
    }

    private val listFoodPhotoAdapter: ListFoodPhotoAdapter by lazy {
        ListFoodPhotoAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvFoodPhoto.layoutManager = linearLayoutManager

        listFoodPhotoAdapter.setData(getListPhotos())

        binding.rcvFoodPhoto.adapter = listFoodPhotoAdapter
    }

    private fun getListPhotos(): MutableList<ListFoodPhoto> {
        return mutableListOf(
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_GRID,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.slide_item_1),
                    FoodPhoto(R.drawable.slide_item_2),
                    FoodPhoto(R.drawable.slide_item_3),
                )
            ),
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_GRID,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.slide_item_2),
                    FoodPhoto(R.drawable.slide_item_4),
                    FoodPhoto(R.drawable.slide_item_3),
                )
            ),
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_LARGE_LEFT,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.food_icon),
                    FoodPhoto(R.drawable.slide_item_3),
                    FoodPhoto(R.drawable.slide_item_2),
                )
            ),
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_GRID,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.slide_item_4),
                    FoodPhoto(R.drawable.food_icon),
                    FoodPhoto(R.drawable.slide_item_2),
                )
            ),
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_LARGE_RIGHT,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.slide_item_3),
                    FoodPhoto(R.drawable.slide_item_2),
                    FoodPhoto(R.drawable.slide_item_1),
                )
            ),
            ListFoodPhoto(
                type = ListFoodPhotoAdapter.TYPE_GRID,
                listFoodPhotos = mutableListOf(
                    FoodPhoto(R.drawable.slide_item_4),
                    FoodPhoto(R.drawable.slide_item_2),
                    FoodPhoto(R.drawable.food_icon),
                )
            ),
        )
    }
}