package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.ItemAdapter
import com.example.recyclerviewexample.databinding.ActivityDragAndDropBinding
import java.util.Collections

class DragAndDropActivity : AppCompatActivity() {
    private val binding: ActivityDragAndDropBinding by lazy {
        ActivityDragAndDropBinding.inflate(layoutInflater)
    }

    private val itemAdapter: ItemAdapter by lazy {
        ItemAdapter(context = applicationContext)
    }

    private var listItems: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvItem.layoutManager = linearLayoutManager

        getListItems()
        itemAdapter.setData(listItems)

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rcvItem.addItemDecoration(divider)

        binding.rcvItem.adapter = itemAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val positionDragged = viewHolder.adapterPosition
                val positionTarget = target.adapterPosition

                Collections.swap(listItems, positionDragged, positionTarget)
                itemAdapter.notifyItemMoved(positionDragged, positionTarget)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            }
        }).apply {
            attachToRecyclerView(binding.rcvItem)
        }
    }

    private fun getListItems() {
        for (i in 0 until 20) {
            listItems.add("Item $i")
        }
    }
}