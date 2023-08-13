package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.adapter.ItemCellAdapter
import com.example.recyclerviewexample.databinding.ActivityFoldingCellBinding
import com.example.recyclerviewexample.model.ItemCell
import com.example.recyclerviewexample.model.ItemObject

class FoldingCellActivity : AppCompatActivity() {
    private val binding: ActivityFoldingCellBinding by lazy {
        ActivityFoldingCellBinding.inflate(layoutInflater)
    }

    private val itemCellAdapter: ItemCellAdapter by lazy {
        ItemCellAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvItem.layoutManager = linearLayoutManager

        itemCellAdapter.setData(getListItemCells())

        binding.rcvItem.adapter = itemCellAdapter
    }

    private fun getListItemCells(): MutableList<ItemCell> {
        val list: MutableList<ItemCell> = mutableListOf()
        for (i in 0 until 20) {
            list.add(ItemCell("Title item $i", "Content item $i"))
        }
        return list
    }
}