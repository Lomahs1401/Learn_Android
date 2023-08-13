package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.databinding.ItemPhotoGridBinding
import com.example.recyclerviewexample.databinding.ItemPhotoLargeLeftBinding
import com.example.recyclerviewexample.databinding.ItemPhotoLargeRightBinding
import com.example.recyclerviewexample.model.ListFoodPhoto

class ListFoodPhotoAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listFoodPhotos: MutableList<ListFoodPhoto> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listPhotos: MutableList<ListFoodPhoto>) {
        this.listFoodPhotos = listPhotos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_GRID -> {
                val binding = ItemPhotoGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FoodPhotoGridViewHolder(binding)
            }
            TYPE_LARGE_LEFT -> {
                val binding = ItemPhotoLargeLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FoodPhotoLargeLeftViewHolder(binding)
            }
            else -> {
                val binding = ItemPhotoLargeRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FoodPhotoLargeRightViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return listFoodPhotos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val listFoodPhoto = listFoodPhotos[position]
        when (listFoodPhoto.type) {
            TYPE_GRID -> {
                val photoGridViewHolder = holder as FoodPhotoGridViewHolder
                photoGridViewHolder.bindData(listFoodPhoto)
            }
            TYPE_LARGE_LEFT -> {
                val photoLargeLeftViewHolder = holder as FoodPhotoLargeLeftViewHolder
                photoLargeLeftViewHolder.bindData(listFoodPhoto)
            }
            else -> {
                val photoLargeRightViewHolder = holder as FoodPhotoLargeRightViewHolder
                photoLargeRightViewHolder.bindData(listFoodPhoto)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listFoodPhotos[position].type
    }

    inner class FoodPhotoGridViewHolder(private val binding: ItemPhotoGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(listFoodPhoto: ListFoodPhoto) {
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img1)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img2)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img3)

//            binding.img1.setImageResource(listFoodPhoto.listFoodPhotos[0].resourceId)
//            binding.img2.setImageResource(listFoodPhoto.listFoodPhotos[1].resourceId)
//            binding.img3.setImageResource(listFoodPhoto.listFoodPhotos[2].resourceId)
        }
    }

    inner class FoodPhotoLargeLeftViewHolder(private val binding: ItemPhotoLargeLeftBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(listFoodPhoto: ListFoodPhoto) {
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img1)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img2)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img3)
//            binding.img1.setImageResource(listFoodPhoto.listFoodPhotos[0].resourceId)
//            binding.img2.setImageResource(listFoodPhoto.listFoodPhotos[1].resourceId)
//            binding.img3.setImageResource(listFoodPhoto.listFoodPhotos[2].resourceId)
        }
    }

    inner class FoodPhotoLargeRightViewHolder(private val binding: ItemPhotoLargeRightBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(listFoodPhoto: ListFoodPhoto) {
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img1)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img2)
            Glide.with(context).load(URL).placeholder(R.drawable.image_not_found).into(binding.img3)
//            binding.img1.setImageResource(listFoodPhoto.listFoodPhotos[0].resourceId)
//            binding.img2.setImageResource(listFoodPhoto.listFoodPhotos[1].resourceId)
//            binding.img3.setImageResource(listFoodPhoto.listFoodPhotos[2].resourceId)
        }
    }

    companion object {
        const val TYPE_GRID = 1
        const val TYPE_LARGE_LEFT = 2
        const val TYPE_LARGE_RIGHT = 3
        const val URL: String = "https://www.responsibletravel.com/imagesClient/dtg-cr29-iceland-landscapes-thumbnail.jpg"
    }
}